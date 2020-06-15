package NivelMedio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nm_Defenirvelocidade  extends TranslatorBlock{

	
	public Nm_Defenirvelocidade  (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);	
}
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
		
		String velo;
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		velo = translatorBlock.toCode();

		
		
		translator.addDefinitionCommand("int velocidade ="+ velo +" ;\r\n");
		return "";
		
		
		}}