package com.ardublock.translator.block.vabc;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class VABCDefineBlock extends TranslatorBlock{

	
		public VABCDefineBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
			super(blockId, translator, codePrefix, codeSuffix, label);
		}

		public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
			
			translator.addHeaderFile("TB6612FNG.h");
			translator.addDefinitionCommand("#define STBY 15\r\n" + 
					"#define PWMA 33\r\n" + 
					"#define AIN1 32\r\n" + 
					"#define AIN2 25\r\n" + 
					"#define PWMB 4\r\n" + 
					"#define BIN1 2\r\n" + 
					"#define BIN2 17\r\n" + 
					"#define STBY1 26\r\n" + 
					"#define PWMC 14\r\n" + 
					"#define CIN1 13\r\n" + 
					"#define CIN2 12" + 
					"\r\n" + 
					"Tb6612fng motors(STBY, AIN1, AIN2, PWMA, BIN1, BIN2, PWMB);\r\n" + 
					"Tb6612fng motor(STBY1, CIN1, CIN2, PWMC);");
			translator.addSetupCommand("motors.begin();\r\n" + 
					"motor.begin();\r\n");
			
			return 	" ";
		}

}
