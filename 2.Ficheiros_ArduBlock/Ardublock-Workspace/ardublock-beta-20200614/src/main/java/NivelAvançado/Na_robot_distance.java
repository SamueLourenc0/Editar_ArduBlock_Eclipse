package NivelAvanšado;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Na_robot_distance extends TranslatorBlock {


	
	public Na_robot_distance  (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
		
		return 	"robot.distance();\r\n"
		;
	}
}