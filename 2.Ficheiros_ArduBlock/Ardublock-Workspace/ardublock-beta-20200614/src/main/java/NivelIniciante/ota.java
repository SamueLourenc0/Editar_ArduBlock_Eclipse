package NivelIniciante;

import java.util.LinkedList;
import java.util.List;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


public class ota extends TranslatorBlock
{
	private List<String> setupCommand;
	
	public ota(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator);
		setupCommand = new LinkedList<String>();
	}
	
	

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String ssid = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String password = translatorBlock.toCode();
		
		if (ssid.equals("ssid") && password.equals("password")) {
			translator.addDefinitionCommand("robotOnLine robot;\r\n");
			translator.addHeaderFile("robotOnLine.h");
			translator.addSetupCommand("Serial.begin(115200);\r\n" +
				    "robot.begin();\r\n");
			
			String ret = "";
			StringBuffer loopCodeBuffer = new StringBuffer();
			translatorBlock = getTranslatorBlockAtSocket(2);
			while (translatorBlock != null) {
				loopCodeBuffer.append(translatorBlock.toCode());
				translatorBlock = translatorBlock.nextTranslatorBlock();
			}

			translator.registerBodyTranslateFinishCallback(this);
			// return "";
			ret = "";
			ret = "void loop()\n{\n" + loopCodeBuffer;
			if (translator.isGuinoProgram())
			{
				ret += "GUINO_GERER_INTERFACE();\n";
			}
			

			if (translator.isScoopProgram()) {
				ret += "yield();\n" + loopCodeBuffer;
			}

			ret = ret + "}\n\n";
			return ret;
			
		} else {
			
			translator.addHeaderFile("ArduinoOTA.h");
			translator.addHeaderFile("robotOnLine.h");
			translator.addDefinitionCommand("robotOnLine robot;\r\n");
			//translator.addHeaderFile("OTA.h");// Adiciona a livraria OTA.h
			//translator.addDefinitionCommand("long lastMsg = 0;" + "\nint flag = false;");
			String ret = "";

			StringBuffer setupCodeBuffer = new StringBuffer();
			translatorBlock = getTranslatorBlockAtSocket(2);
			while (translatorBlock != null) {
				setupCodeBuffer.append(translatorBlock.toCode());
				translatorBlock = translatorBlock.nextTranslatorBlock();
			}
			
			translator.addSetupCommand("Serial.begin(115200);\r\n" + 
					"  delay (100);\r\n" + 
					"\r\n" + 
					"  \r\n" + 
					"  WiFi.disconnect(true);  //disconnect form wifi to set new wifi connection\r\n" + 
					"  WiFi.mode(WIFI_STA); //init wifi mode\r\n" + 
					"  WiFi.begin(\"" + ssid + "\", \""+ password + "\");\r\n" + 
					"  while (WiFi.waitForConnectResult() != WL_CONNECTED)\r\n" + 
					"  {\r\n" + 
					"    Serial.println(\"Connection Failed! Rebooting...\");\r\n" + 
					"    delay(2000);\r\n" + 
					"    ESP.restart();\r\n" + 
					"  }\r\n" + 
					"\r\n" + 
					"  ArduinoOTA\r\n" + 
					"    .onStart([]()\r\n" + 
					"      {\r\n" + 
					"        String type;\r\n" + 
					"        if (ArduinoOTA.getCommand() == U_FLASH)\r\n" + 
					"          type = \"sketch\";\r\n" + 
					"        else // U_SPIFFS\r\n" + 
					"          type = \"filesystem\";\r\n" + 
					"  \r\n" + 
					"        // NOTE: if updating SPIFFS this would be the place to unmount SPIFFS using SPIFFS.end()\r\n" + 
					"        Serial.println(\"Start updating \" + type);\r\n" + 
					"      }\r\n" + 
					"    ).onEnd([]()\r\n" + 
					"      {\r\n" + 
					"        Serial.println(\"\\nEnd\");\r\n" + 
					"      }\r\n" + 
					"    ).onProgress([](unsigned int progress, unsigned int total)\r\n" + 
					"      {\r\n" + 
					"        Serial.printf(\"Progress: %u%%\\r\", (progress / (total / 100)));\r\n" + 
					"      }\r\n" + 
					"    ).onError([](ota_error_t error)\r\n" + 
					"      {\r\n" + 
					"        Serial.printf(\"Error[%u]: \", error);\r\n" + 
					"        if (error == OTA_AUTH_ERROR) Serial.println(\"Auth Failed\");\r\n" + 
					"        else if (error == OTA_BEGIN_ERROR) Serial.println(\"Begin Failed\");\r\n" + 
					"        else if (error == OTA_CONNECT_ERROR) Serial.println(\"Connect Failed\");\r\n" + 
					"        else if (error == OTA_RECEIVE_ERROR) Serial.println(\"Receive Failed\");\r\n" + 
					"        else if (error == OTA_END_ERROR) Serial.println(\"End Failed\");\r\n" + 
					"      }\r\n" + 
					");\r\n" + 
					"  ArduinoOTA.begin();\r\n" );

			StringBuffer loopCodeBuffer = new StringBuffer();
			translatorBlock = getTranslatorBlockAtSocket(2);
			while (translatorBlock != null) {
				loopCodeBuffer.append(translatorBlock.toCode());
				translatorBlock = translatorBlock.nextTranslatorBlock();
			}

			ret = "void loop()\n{\n  ArduinoOTA.handle();\n\n" + loopCodeBuffer;

			ret = ret + "}\n\n";
			return ret;

		}
	}

	@Override
	public void onTranslateBodyFinished() {
		for (String command : setupCommand) {
			translator.addSetupCommandForced(command);
		}
	}
	
}
