package NivelAvançado;

import java.util.LinkedList;
import java.util.List;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


public class bota extends TranslatorBlock
{
	private List<String> setupCommand;
	
	public bota(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator);
		setupCommand = new LinkedList<String>();
	}
	
	

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String ssid = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String password = translatorBlock.toCode();
		
		if (ssid.equals("ssid") && password.equals("password")) {

			translator.addDefinitionCommand("robotOnLine robot;\r\n");
			translator.addHeaderFile("robotOnLine.h");
			translator.addSetupCommand("Serial.begin(115200);" + "robot.begin();\r\n");
			
			String ret = "";

			translatorBlock = getTranslatorBlockAtSocket(2);
			while (translatorBlock != null) {

				ret = translatorBlock.toCode();
				translatorBlock = translatorBlock.nextTranslatorBlock();
				this.setupCommand.add(ret);
			}

			translator.registerBodyTranslateFinishCallback(this);
			// return "";
			ret = "";
			ret = "void loop()\n{\n";
			TranslatorBlock translatorBlock2 = getTranslatorBlockAtSocket(3);
			while (translatorBlock2 != null) {

				ret = ret + translatorBlock2.toCode();
				translatorBlock2 = translatorBlock2.nextTranslatorBlock();
			}

			if (translator.isScoopProgram()) {
				ret += "yield();\n";
			}

			ret = ret + "}\n\n";
			return ret;
			
		} else {
			
			translator.addHeaderFile("OTA.h");// Adiciona a livraria OTA.h
			translator.addDefinitionCommand("long lastMsg = 0;" + "\nint flag = false;");
			String ret = "";

			StringBuffer setupCodeBuffer = new StringBuffer();
			translatorBlock = getTranslatorBlockAtSocket(2);
			while (translatorBlock != null) {
				setupCodeBuffer.append(translatorBlock.toCode());
				translatorBlock = translatorBlock.nextTranslatorBlock();
			}

			translator.addSetupCommand(" Serial.begin(115200);\r\n" + "  delay (100);\r\n"
					+ "  //OTASetup(ssid, password, hostname, passwordupdate, port);\r\n" + "  OTASetup(\"" + ssid + "\", \""
					+ password + "\", \"OTA ESP32\", \"admin\", 80);" + "\n" + setupCodeBuffer);

			StringBuffer loopCodeBuffer = new StringBuffer();
			translatorBlock = getTranslatorBlockAtSocket(3);
			while (translatorBlock != null) {
				loopCodeBuffer.append(translatorBlock.toCode());
				translatorBlock = translatorBlock.nextTranslatorBlock();
			}

			ret = "void loop()\n{\nHANDLE();\n\n" + loopCodeBuffer;

			ret = ret + "}\n\n";
			return ret;

		}
	}

	@Override
	public void onTranslateBodyFinished() {
		for (String command : setupCommand) {
			translator.addSetupCommandForced(command);
		}
	}
	
}
