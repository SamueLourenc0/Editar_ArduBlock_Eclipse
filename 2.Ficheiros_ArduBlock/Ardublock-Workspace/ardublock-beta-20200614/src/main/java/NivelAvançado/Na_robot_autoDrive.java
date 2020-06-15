package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_autoDrive extends TranslatorBlock {


	
	public Na_robot_autoDrive (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String by = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String var = translatorBlock.toCode();
		
		
		translator.addDefinitionCommand("int "+var+";\r\n");
		translator.addSetupCommand("robot.beginAutoDrive();");

		
		return 	""+var+" = robot.autoDrive("+by+");";
	}
}




