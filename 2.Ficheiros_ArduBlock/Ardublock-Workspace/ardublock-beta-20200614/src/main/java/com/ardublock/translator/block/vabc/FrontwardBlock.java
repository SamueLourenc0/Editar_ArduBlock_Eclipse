package com.ardublock.translator.block.vabc;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class FrontwardBlock extends TranslatorBlock{

	
		public FrontwardBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
			super(blockId, translator, codePrefix, codeSuffix, label);
		}

		public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
			
			//translator.addHeaderFile("");
			translator.addDefinitionCommand("\n");
			TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
			String speedr = translatorBlock.toCode();
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
			String speedl = translatorBlock.toCode();
			
			speedr=speedr.substring(9,speedr.length());
			speedl=speedl.substring(9,speedl.length());
			int speedrint=Integer.parseInt(speedr);
			int speedlint=Integer.parseInt(speedl);
			
			if(speedrint>255) {
				speedrint=255;
			}else if (speedrint<0) {
				speedrint=0;
			}
			
			if(speedlint>255) {
				speedlint=255;
			}else if (speedlint<0) {
				speedlint=0;
			}
			
			return 	"    //Frontward block\r\n" + 
					"	 ledcWrite(0, " + speedrint + ");//EN1\r\n" + 
					"    ledcWrite(1, "+ speedlint + ");//EN2\r\n" + 
					"    delay(20);\r\n" + 
					"    Serial.println(\"frontward time!\");\r\n" + 
					"    digitalWrite(inputPinR1, HIGH);\r\n" + 
					"    digitalWrite(inputPinR2, LOW);\r\n" + 
					"    digitalWrite(inputPinL1, HIGH);\r\n" + 
					"    digitalWrite(inputPinL2, LOW);\r\n" ;
		}

}


