package NivelMedio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nm_ConfiguraçãoEncoder extends TranslatorBlock{

	public Nm_ConfiguraçãoEncoder (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
	translator.addDefinitionCommand("");
	translator.addSetupCommand(
			
			  "int totalpulsos = 0;\r\n" +
			  "int antespulsos = 0;\r\n" +
			  "int pulsos = 0;\r\n" +
			  "int rpm = 0;\r\\n" +
			  "int timeold = 0;\r\n" +
			  "int totaldireitapulsos =0;\r\n" +
			  "int totalesquerdapulsos =0;\r\n" +
			  "int Agorapulsos=0;\r\n");
	
	return 	"totalesquerdapulsos = robot.getLeftEncoderCount();\r\n" +
	        "totaldireitapulsos = robot.getRightEncoderCount();\r\n";
}
}