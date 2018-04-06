package ch05.exercise.problem13;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class LogRecordFilter {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("ch05.exercise.problem13");
		logger.setUseParentHandlers(false);
		Handler consoleHandler = new ConsoleHandler();
		consoleHandler.setFilter(r -> {
			String msg = r.getMessage();
			String[] badWords = {"sex", "drug", "C++"};
			return Arrays.stream(badWords)
					.anyMatch(msg::contains);
		});
		logger.addHandler(consoleHandler);
		
		logger.info("a a");
		logger.info("a a sex");
		logger.info("a a");
		logger.info("a drug a");
		logger.info("C++ a");
	}
}
