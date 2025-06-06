package org.Nav.explore.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
   
	private static Properties properties = new Properties();
	
	static {
		System.out.println("Static block of ConfigManager started");
		InputStream ip = ConfigManager.class.getClassLoader().getResourceAsStream("configuration/config.properties");
		if (ip == null) {
		    System.err.println("config.properties NOT found at runtime!");
		    System.err.println("Current working directory: " + System.getProperty("user.dir"));
		    throw new RuntimeException("config.properties not found in classpath");
		}
		try {
			properties.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
  
	public static String getProperties(String key) {
		return properties.getProperty(key).trim();
	}
	
	public static void setProperties(String key, String value) {
		properties.setProperty(key, value);
	}

	
}
