package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_editMotorPin extends TranslatorBlock{

	
	public Na_robot_editMotorPin (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
		
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String INT1 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String INT2 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
		String INT3 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
		String INT4 = translatorBlock.toCode();
		
		
		
		translator.addSetupCommand(" robot.editMotorPin("+INT1+", "+INT2+","+INT3+", "+INT4+");\r\n ");
		
		
		return "" ;
		
		
		
	}

}