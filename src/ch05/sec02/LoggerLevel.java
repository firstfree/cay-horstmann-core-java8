package ch05.sec02;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerLevel {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("ch05.sec02");
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		logger.addHandler(handler);
			
		logger.finest("finest");
		logger.finer("finer");
		logger.fine("fine");
		logger.config("config");
		logger.info("info");
		logger.warning("warning");
		logger.severe("severe");
	}
}
