package com.configreader.propertiesFileReader.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private static Properties prop;

	static {
		try (InputStream input = ClassLoader.class.getResourceAsStream("/config.properties")) {
			prop = new Properties();
			prop.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Config File not Found!");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Error Occurred while reading file");
			e.printStackTrace();

		}
	}

	public String getKey(String key) {
		return prop.getProperty(key);
	}

}
