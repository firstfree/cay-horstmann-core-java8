package ch05.sec02;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerEtc {
	private static Logger logger = Logger.getLogger("ch05.sec02");
	
	public static int read(String file, String pattern) {
		logger.entering("ch05.sec02.LoggerEtc", "read", new Object[]{ file, pattern });
		
		int count = 2;
		
		logger.exiting("ch05.sec02.LoggerEtc", "read", count);
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		logger.setLevel(Level.FINER);
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINER);
		logger.addHandler(handler);
		
		read("config", "txt");
		
		try {
			throw new IOException();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot read configuration", e);
		}
		
		IOException ex = new IOException();
		logger.throwing("ch05.sec02.LoggerEtc", "read", ex);
		throw ex;
	}
}
