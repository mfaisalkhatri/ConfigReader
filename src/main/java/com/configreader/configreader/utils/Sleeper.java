package com.configreader.configreader.utils;

import org.apache.log4j.Logger;



public class Sleeper {
	
	private static Logger logger = Logger.getLogger(Sleeper.class);
	private Sleeper() throws IllegalAccessException {
		throw new IllegalAccessException();
	}
	
	public static void sleep(int timeout) throws InterruptedException {
		try {
		Thread.sleep(timeout);
		}
		catch(Exception e) {
			logger.error("Exception occurred in sleeper class", e);
		}
		
	}

}
