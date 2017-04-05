package com.edu.infnet.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	
	private static Log instance = null;
	
	private Log(){}

	public static Log getInstance() {
		if (instance == null) {
			instance = new Log();
		}
		return instance;
	}
	
	public Logger getLogger(String name) {
		Logger logger = Logger.getLogger(name);
		logger.setLevel(Level.ALL);
		return logger;	
	}
	
}
