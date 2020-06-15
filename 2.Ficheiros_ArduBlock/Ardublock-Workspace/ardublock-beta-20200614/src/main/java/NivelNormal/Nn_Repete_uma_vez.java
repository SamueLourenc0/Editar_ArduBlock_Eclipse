package NivelNormal;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


	public class Nn_Repete_uma_vez extends TranslatorBlock{

		public Nn_Repete_uma_vez (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
		{
			super(blockId, translator, codePrefix, codeSuffix, label);
		}
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		translator.addDefinitionCommand("int var=1;\r\n");
		String ret = "";

		

		translator.registerBodyTranslateFinishCallback(this);
		// return "";
		ret = "";
		ret = "while(var==1)\n{\n";
		TranslatorBlock translatorBlock2 = getTranslatorBlockAtSocket(0);
		while (translatorBlock2 != null) {

			ret = ret + translatorBlock2.toCode();
			translatorBlock2 = translatorBlock2.nextTranslatorBlock();
		}

		if (translator.isScoopProgram()) {
			ret += "yield();\n";
		}

		ret = ret + "var=0;\n}\n";
		return ret;
		      
	}}