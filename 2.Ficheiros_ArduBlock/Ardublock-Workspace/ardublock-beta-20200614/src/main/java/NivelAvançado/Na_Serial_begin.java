package NivelAvançado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_Serial_begin  extends TranslatorBlock{

	
	public Na_Serial_begin  (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		String speed;
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		speed= translatorBlock.toCode();
		translator.addSetupCommand("Serial.begin("+speed+");");
		return "";
	}
	
	
}