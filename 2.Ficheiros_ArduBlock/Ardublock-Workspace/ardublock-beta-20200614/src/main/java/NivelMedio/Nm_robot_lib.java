package NivelMedio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nm_robot_lib  extends TranslatorBlock{
	public Nm_robot_lib(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
	
	translator.addHeaderFile("ArduinoOTA.h");
	translator.addHeaderFile("robotOnLine.h");
	translator.addDefinitionCommand("robotOnLine robot;\r\n");
	translator.addSetupCommand(
		    "robot.begin();\r\n");
	return 	"" ;

}
}
