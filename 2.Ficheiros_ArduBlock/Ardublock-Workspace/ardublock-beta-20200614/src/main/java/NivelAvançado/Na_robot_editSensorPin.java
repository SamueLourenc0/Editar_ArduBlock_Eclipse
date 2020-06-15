package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_editSensorPin extends TranslatorBlock{

	
	public Na_robot_editSensorPin (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
		
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String S1 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String S2 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
		String S3 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
		String S4 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(4);
		String S5 = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(5);
		String CLP = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(6);
		String Near = translatorBlock.toCode();
		
		translator.addSetupCommand(" robot.editSensorPin( "+S1+", "+S2+", "+S3+", "+S4+", "+S5+", "+CLP+", "+Near+");\r\n ");
		
		
		return "" ;
		
		
		
	}

}