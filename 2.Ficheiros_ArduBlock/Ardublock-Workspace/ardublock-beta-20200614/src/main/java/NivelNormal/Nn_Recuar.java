package NivelNormal;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Nn_Recuar extends TranslatorBlock{

	public Nn_Recuar (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
@Override
public String toCode() throws SocketNullException, SubroutineNotDeclaredException
{
	String cm;
	TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	cm = translatorBlock.toCode();

	
	
	translator.addHeaderFile("robotOnLine.h");
	translator.addDefinitionCommand( 
			  "int totalpulsos = 0;\r\n" +
			  "int antespulsos = 0;\r\n" +
			  "int pulsos = 0;\r\n" +
			  "int rpm = 0;\r\n" +
			  "int timeold = 0;\r\n" +
			  "int totaldireitapulsos =0;\r\n" +
			  "int totalesquerdapulsos =0;\r\n" +
			  "int Agorapulsos=0;\r\n" );
	translator.addSetupCommand("Serial.begin(115200);\r\n" +
		    "robot.begin();\r\n");

	
	return 	  "robot.clearEncoderCount();\r\n" +
	          "robot.reverse(velocidade); \r\n" +
			  "totalesquerdapulsos = robot.getLeftEncoderCount();\r\n" +
		      "totaldireitapulsos = robot.getRightEncoderCount();\r\n" +
		      "totalpulsos = ((totaldireitapulsos/2) + (totalesquerdapulsos/2))/2;\r\n" +
		      "while(pulsos <= ("+ cm +" )) \r\n" +
		      "{ \r\n" +
		      "antespulsos = totalpulsos;\r\n" +
		      "totalesquerdapulsos = robot.getLeftEncoderCount();\r\n" +
		      "totaldireitapulsos = robot.getRightEncoderCount();\r\n" +
		      "Agorapulsos = ((totaldireitapulsos/2) + (totalesquerdapulsos/2))/2;\r\n" +
		      "pulsos= Agorapulsos-antespulsos ; \r\n" +
		      "} \r\n" +
		      "robot.stopMotors(); \r\n" +
		      "pulsos =0;\r\n" ;
			 
         
	      
}}