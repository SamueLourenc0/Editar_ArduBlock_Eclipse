package NivelMedio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nm_Temporiza extends TranslatorBlock{

	public Nm_Temporiza  (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);	
}
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
		String seg;
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		seg = translatorBlock.toCode();

		
		
		return"delay("+ seg +" *1000);\r\n";
		
		
		}}