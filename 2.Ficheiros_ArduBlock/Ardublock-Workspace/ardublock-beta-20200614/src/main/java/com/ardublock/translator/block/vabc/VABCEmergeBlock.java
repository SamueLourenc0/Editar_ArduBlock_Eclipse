package com.ardublock.translator.block.vabc;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class VABCEmergeBlock extends TranslatorBlock{

	public VABCEmergeBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String speed = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String time = translatorBlock.toCode();
		
		speed=speed.substring(9,speed.length());
		time=time.substring(9,time.length());
		int speedint=Integer.parseInt(speed);
		int timeint=Integer.parseInt(time);
		
		return 	"motor.drive(-"+speedint+".0, "+timeint+");";
		
	}
}
