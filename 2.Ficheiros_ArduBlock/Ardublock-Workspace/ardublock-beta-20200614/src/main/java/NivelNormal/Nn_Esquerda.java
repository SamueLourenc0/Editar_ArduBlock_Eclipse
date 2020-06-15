package NivelNormal;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nn_Esquerda extends TranslatorBlock{

	
	public Nn_Esquerda (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String cm;
			TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
			cm = translatorBlock.toCode();
			
			
			//translator.addDefinitionCommand("robotOnLine robot;\r\n");
			translator.addHeaderFile("robotOnLine.h");
			translator.addSetupCommand("Serial.begin(115200);\r\n" +
				    "robot.begin();\r\n");

			
			return  "robot.turnLeft("+ cm +");" ;		

	}

}