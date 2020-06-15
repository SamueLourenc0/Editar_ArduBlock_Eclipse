package NivelAvanšado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_bibli_robotOnLine extends TranslatorBlock {


	
	public Na_bibli_robotOnLine  (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
		translator.addHeaderFile("iModBot.h");
		translator.addDefinitionCommand("iModBot robot;\r\n");
		return 	""
		;
	}
}