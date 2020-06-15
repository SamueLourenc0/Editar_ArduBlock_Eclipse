package com.ardublock.translator.block.vabc;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class VABCStopMRLBlock extends TranslatorBlock{

	
		public VABCStopMRLBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
			super(blockId, translator, codePrefix, codeSuffix, label);
		}

		public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
			
			return 	"motors.brake();";
			
			
		}

}