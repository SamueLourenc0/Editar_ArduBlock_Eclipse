package NivelIniciante;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Ni_SeguirLinha extends TranslatorBlock{

	
	public Ni_SeguirLinha (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
		
		
		
		
		translator.addHeaderFile("robotOnLine.h");
		translator.addDefinitionCommand(				"\r\n ");
		translator.addSetupCommand(
		  "robot.beginAutoDrive();" );
		
		return 	" robot.autoDrive(0);\r\n";
	}

}