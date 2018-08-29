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
			if (input != null) {
				prop.load(input);
				logger.info("Properties File loaded successfully.");

			} else {
				throw new FileNotFoundException();
			}

		} catch (FileNotFoundException e) {
			logger.error("Config File not Found!", e);

		} catch (IOException e) {
			logger.error("Error Occurred while loading file", e);

		}
	}

	public String getKey(String key) throws IOException {

		try {
			String val = prop.getProperty(key);
			if (val == null) {
				throw new IOException();
			}
		} catch (IOException e) {
			logger.error(key + " - Key not found in the file..");
		}
		return prop.getProperty(key);
	}
}