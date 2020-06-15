package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_setSpeeds extends TranslatorBlock{

	
	public Na_robot_setSpeeds (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
		
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String b1 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String b2 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
		String b3 = translatorBlock.toCode();

		
		translator.addSetupCommand("  robot.setSpeeds("+b1+", "+b2+","+b3+");\r\n ");
		
		
		return "" ;
		
		
		
	}

}
		
		
	