package NivelNormal;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nn_DesviarObestaculos extends TranslatorBlock{
	
	public Nn_DesviarObestaculos (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
	
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	@Override
public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
		String cm;
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		cm = translatorBlock.toCode();
		
		
	//translator.addHeaderFile("robotOnLine.h");	
	//translator.addDefinitionCommand("robotOnLine robot;\r\n");
	//translator.addSetupCommand("robot.begin();\r\n");
	
	return "  if(robot.distance() < "+ cm +"){\r\n" + 
		   "     robot.stopMotors();}" ;

}
}