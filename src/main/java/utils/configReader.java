package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	
	public Properties intializeProperties() {
		
		Properties prop = new Properties();
		File profile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		
		try {
		FileInputStream file = new FileInputStream(profile);
		prop.load(file);
	}catch(Throwable e) {
		e.printStackTrace();
	}

		return prop;
}
}
