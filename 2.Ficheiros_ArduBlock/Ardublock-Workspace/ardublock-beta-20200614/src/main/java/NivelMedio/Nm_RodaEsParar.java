package NivelMedio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nm_RodaEsParar extends TranslatorBlock {
	public Nm_RodaEsParar (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
	translator.addDefinitionCommand("");
	translator.addSetupCommand(" ");
	
	return 	"robot.leftWheel(0);\r\n";

}
}
