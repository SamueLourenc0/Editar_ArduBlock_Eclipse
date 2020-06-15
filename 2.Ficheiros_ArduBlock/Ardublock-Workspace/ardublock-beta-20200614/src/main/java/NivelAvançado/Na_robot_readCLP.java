package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_readCLP extends TranslatorBlock {


	
	public Na_robot_readCLP  (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
		
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String variavel = translatorBlock.toCode();
		
		translator.addDefinitionCommand("int "+variavel+";\r\n");
		
		return 	""+variavel+" = robot.readCLP(); \r\n"
		;
	}
}