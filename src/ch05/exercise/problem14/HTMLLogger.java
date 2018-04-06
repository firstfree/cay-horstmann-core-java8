package ch05.exercise.problem14;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class HTMLLogger {
	public static void main(String[] args) throws IOException {
		Logger logger = Logger.getLogger("ch05.exercise.problem14");
		logger.setUseParentHandlers(false);
		Handler fileHandler = new FileHandler("html-logger-%g.html");
		fileHandler.setFormatter(new HTMLFormatter());
		logger.addHandler(fileHandler);
		logger.addHandler(new ConsoleHandler());
		
		logger.info("ㅇㅇㅇ가나");
	}
}
