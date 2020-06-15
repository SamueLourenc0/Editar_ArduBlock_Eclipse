package NivelIniciante;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Ni_LigarLed extends TranslatorBlock{

	
	public Ni_LigarLed (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		

		translator.addDefinitionCommand("unsigned long enlapsedTime=0;");
		translator.addSetupCommand("  pinMode(LED_BUILTIN, OUTPUT);");
		
		return "if( millis() > enlapsedTime+2000 )\r\n"
		        +"{\r\n"
		        +"digitalWrite(LED_BUILTIN, HIGH);\r\n"
		        +"enlapsedTime=millis();\r\n"
		        +"}\r\n"
		        +"else if( millis() > enlapsedTime+1000 )\r\n "
		        +"{\r\n"
		        +"digitalWrite(LED_BUILTIN, LOW);\r\n"  
		        +"}\r\n" ;
		
	}

}