package NivelMedio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nm_RodaDirParar  extends TranslatorBlock {
	public  Nm_RodaDirParar (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
	translator.addDefinitionCommand("");
	translator.addSetupCommand(" ");
	
	return "robt.rightWheel(0);\r\n" ;

}
}
