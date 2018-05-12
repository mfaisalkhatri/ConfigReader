package com.configreader.utils;

public class Sleeper {
	
	public static void sleep(int timeout) throws InterruptedException {
		try {
		Thread.sleep(timeout);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
