package NivelAvanšado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_digitalWrite extends TranslatorBlock{

		public Na_digitalWrite (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
		{
			super(blockId, translator, codePrefix, codeSuffix, label);
		}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{	
		
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String pin = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String value = translatorBlock.toCode();
		
		return("  digitalWrite("+pin+", "+value+"); ");
			
	}

}