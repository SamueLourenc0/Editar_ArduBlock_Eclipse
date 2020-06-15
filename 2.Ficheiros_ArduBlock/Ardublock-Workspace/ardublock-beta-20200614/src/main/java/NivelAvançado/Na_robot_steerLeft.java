package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_steerLeft extends TranslatorBlock{

	
	public Na_robot_steerLeft (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
		
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String velo = translatorBlock.toCode();
		
		
		return "robot.steerLeft("+velo+");\r\n" ;
		
		
		
	}

}