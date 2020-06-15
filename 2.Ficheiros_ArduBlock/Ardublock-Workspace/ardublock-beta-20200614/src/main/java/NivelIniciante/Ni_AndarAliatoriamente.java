package NivelIniciante;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Ni_AndarAliatoriamente extends TranslatorBlock{

	
	public Ni_AndarAliatoriamente (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
	
		
		translator.addHeaderFile("robotOnLine.h");
		translator.addSetupCommand(
			    "robot.begin();\r\n");
		translator.addDefinitionCommand(
				
				"int period = 2500;\r\n" + 
				"unsigned long time_now = 0;\r\n" + 
				"char randNumber;");

		
		return 	" if(millis() >= time_now + period){\r\n" + 
				"        time_now += period;\r\n" + 
				"        randNumber = random(500);\r\n" + 
				"        Serial.println(randNumber);\r\n" + 
				"          }\r\n" + 
				"   \r\n" + 
				"    if (randNumber <= 100){robot.forward(200);}\r\n" + 
				"    if (randNumber > 100 && randNumber <= 200)"+ 
				"       {robot.rotateLeft(200);}\r\n" + 
				"    if (randNumber > 200 && randNumber <= 300){robot.reverse(200);}\r\n" + 
				"    if (randNumber > 300 && randNumber < 400){robot.rotateRight(200);}\r\n" + 
				"    if (randNumber >= 400){robot.stopMotors();}\r\n" ;
	}

}