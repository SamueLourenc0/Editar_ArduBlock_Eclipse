package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_getRightMS  extends TranslatorBlock {


	
	public Na_robot_getRightMS(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String variavelnome = translatorBlock.toCode();
	
		
		translator.addDefinitionCommand("float "+variavelnome+";\r\n");
		
		return""+variavelnome+" = robot.getRightMS(); \r\n";
		
	}
}