package NivelIniciante;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Ni_GuiarPorBluetooth  extends TranslatorBlock{

	public Ni_GuiarPorBluetooth (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
			
		String velo;
			
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		velo = translatorBlock.toCode();

		translator.addHeaderFile("robotOnLine.h");
		translator.addDefinitionCommand("#include \"BluetoothSerial.h\"\r\n" +  
				"BluetoothSerial ESP_BT;\r\n" + 
				"robotOnLine robot;\r\n" );
		
		translator.addSetupCommand(" //Serial.begin(115200);\r\n" + 
				"  ESP_BT.begin(\"Edurobot\");\r\n" + 
				"  robot.begin();\r\n" + 
				"  ESP_BT.println(\"Hello! Robot Conected!\");\r\n"+
				"");
		return   "void loop(){"+
				"  char msg =  ESP_BT.read();  // receive information\r\n" + 
				"\r\n" + 
				"if (msg > 32 && msg <126){"+
				"  // Now it's a matter of playing with the bluetooth functions\r\n" + 
				"\r\n" + 
				"  switch (msg) {\r\n" + 
				"    case 'a':\r\n" + 
				"      robot.forward("+velo+");\r\n" + 
				"      break;\r\n" + 
				"    case 'b':\r\n" + 
				"      robot.rotateRight("+velo+");\r\n" + 
				"      break;\r\n" + 
				"    case 'c':\r\n" + 
				"      robot.rotateLeft("+velo+");\r\n" + 
				"      break;\r\n" + 
				"    case 'd':\r\n" + 
				"      robot.reverse("+velo+");\r\n" + 
				"      break;\r\n" + 
				"\r\n" + 
				"    default:\r\n" + 
				"      robot.stopMotors();\r\n" + 
				"      break;\r\n" + 
				"  }\r\n" + 
				" }\r\n" +
				"delay(100);\r\n" +
				"}";
		
		
		
	}

}

