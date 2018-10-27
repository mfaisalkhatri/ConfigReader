package com.configreader.configreader.utils;

import org.apache.log4j.Logger;



/**
 * This method is used to define the wait time.
 * @author Faisal Khatri
 * @version 1.0.0
 * @since 2018-10-20
 */
public class Sleeper {
	
	private static Logger logger = Logger.getLogger(Sleeper.class);
	private Sleeper() throws IllegalAccessException {
		throw new IllegalAccessException();
	}
	
	/**
	 * @param timeout
	 * @throws InterruptedException
	 */
	public static void sleep(int timeout) throws InterruptedException {
		try {
		Thread.sleep(timeout);
		}
		catch(Exception e) {
			logger.error("Exception occurred in sleeper class", e);
		}
		
	}

}
