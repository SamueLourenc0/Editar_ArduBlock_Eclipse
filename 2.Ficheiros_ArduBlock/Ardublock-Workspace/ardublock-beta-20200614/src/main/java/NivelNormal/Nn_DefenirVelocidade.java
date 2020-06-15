package NivelNormal;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nn_DefenirVelocidade extends TranslatorBlock{

	
	public Nn_DefenirVelocidade (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}


	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
	String nivel;
	TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	nivel = translatorBlock.toCode();
	
	translator.addDefinitionCommand("int nivel;\r\n" + "int velocidade;\r\n");
	
	return
		"nivel= "+nivel+";"
+	"switch (nivel) {\r\n"
+	  "case 1:\r\n"
+		  "velocidade=150;\r\n"
+		  "nivel=0;\r\n"
+	    "break;\r\n"
+	  "case 2:\r\n"
+		  "velocidade=200;\r\n"
+		  "nivel=0;\r\n"
+	    "break;\r\n"
+	  "case 3:\r\n"
+		  "velocidade=255;\r\n"
+		  "nivel=0;\r\n"
+		"break;}\r\n" ;
	 
	}}