package com.configreader.configreader.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesReader {
	private static Properties prop;
	private static Logger logger = Logger.getLogger(PropertiesReader.class);

	static {
		try (InputStream input = ClassLoader.class.getResourceAsStream("/config.properties")) {
			prop = new Properties();
			prop.load(input);
			logger.info("Properties File loaded successfully.");
		} catch (FileNotFoundException e) {
			logger.error("Config File not Found!", e);

		} catch (IOException e) {
			logger.error("Error Occurred while reading file", e);

		}
	}

	public String getKey(String key) {
		return prop.getProperty(key);

	}

}
