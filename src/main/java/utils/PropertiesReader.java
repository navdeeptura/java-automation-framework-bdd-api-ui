package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	
	private static Properties prop = new Properties();
	
	
	static {
		try (InputStream input = PropertiesReader.class.getClassLoader()
			    .getResourceAsStream("config/test-config.properties");)
		{
			prop.load(input);
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("Failed to Load Properties File " + e.getMessage());
		}
	}
	
	public static String get(String key) {
		return prop.getProperty(key);
	}
	
	public static int getInt(String key) {
		return Integer.parseInt(prop.getProperty(key));
	}
	
	public static boolean getBoolean(String key) {
		return Boolean.parseBoolean(prop.getProperty(key));
	}

}
