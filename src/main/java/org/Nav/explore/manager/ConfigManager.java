package org.Nav.explore.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
   /*
	private static Properties properties = new Properties();
	
	static {
		
		InputStream ip = ConfigManager.class.getClassLoader().getResourceAsStream("configuration/config.properties");
		try {
			properties.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
*/
	
	
	    private static final Properties properties = new Properties();
	    
	    static {
	        try {
	            // Load the properties file
	            InputStream ip = ConfigManager.class.getClassLoader()
	                .getResourceAsStream("configuration/config.properties");
	            
	            if (ip == null) {
	               
	                throw new RuntimeException("config.properties not found in classpath");
	            }
	            
	            properties.load(ip);
	            ip.close();
	            
	           
	        } catch (IOException e) {
	            
	            throw new RuntimeException("Failed to load configuration", e);
	        }
	    }
	    
	public static String getProperties(String key) {
		return properties.getProperty(key).trim();
	}
	
	public static void setProperties(String key, String value) {
		properties.setProperty(key, value);
	}

	
}
