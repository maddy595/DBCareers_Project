package com.db.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	//private static String browserType=null;
	
	public static Properties prop;
	private static String configPath="C:\\Users\\HP\\eclipse-workspace\\DBCareers_Project\\src\\test\\java\\com\\db\\utils\\config.properties";
	
	public static void initializePropertyFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(configPath);
		prop.load(fis);
		
	}
	
/*	public static void setBrowserType(String browser) {
		browserType = browser;
	}

	public static String getBrowserType() {
		if(browserType!= null) {
			return browserType;
		}else {
			throw new RuntimeException("Incorrect browser name found. Please enter only 'Chrome' or Edge");
		}
	} */
	

}
