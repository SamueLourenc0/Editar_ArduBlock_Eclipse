package NivelIniciante;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Ni_AndarARoda extends TranslatorBlock{

	
	public Ni_AndarARoda (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		translator.addDefinitionCommand("robotOnLine robot;\r\n");
		translator.addHeaderFile("robotOnLine.h");
		translator.addSetupCommand("Serial.begin(115200);\r\n" +
			    "robot.begin();\r\n");
		
		
		return 	"robot.rotateLeft(200);"
		;
	}
}