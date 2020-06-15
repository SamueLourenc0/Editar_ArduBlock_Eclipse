package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_rotateRightMS extends TranslatorBlock{

	
	public Na_robot_rotateRightMS (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
		
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String valorfloat = translatorBlock.toCode();
		
		
		return "robot.rotateRightMS("+valorfloat+");\r\n" ;
		
		
		
	}

}