package ch05.sec02;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class LoggerFileHandler {
	public static void main(String[] args) throws SecurityException, IOException {
		Logger logger = Logger.getLogger("ch05.sec02");
		Handler handler = new FileHandler("logger-file-handler-%g.log", 500, 3, true);
		logger.addHandler(handler);
		
		logger.info(() -> "logger file handler test!");
	}
}
