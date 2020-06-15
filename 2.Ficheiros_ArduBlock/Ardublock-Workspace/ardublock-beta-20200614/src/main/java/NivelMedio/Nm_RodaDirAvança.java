package NivelMedio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nm_RodaDirAvança   extends TranslatorBlock{

	
	public  Nm_RodaDirAvança   (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		


			
		return "robot.rightWheel(velocidade);\r\n" ;
		
	}

}