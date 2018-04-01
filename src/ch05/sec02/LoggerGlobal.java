package ch05.sec02;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerGlobal {
	public static void main(String[] args) {
		String filename = "config.txt";
		Logger.getGlobal().info(() -> "Opening file " + filename);
		Logger.getGlobal().setLevel(Level.OFF);
		Logger.getGlobal().info(() -> "Opening file " + filename);
	}
}
