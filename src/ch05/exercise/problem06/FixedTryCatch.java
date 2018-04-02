package ch05.exercise.problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FixedTryCatch {
	public static void fixWithFinally() {
		BufferedReader in = null;
		
		try {
			in = Files.newBufferedReader(Paths.get("floatingpoint.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Could not close.");
				}
			}
		}
	}
	
	public static void fixWithNestedTryFinally() {
		try {
			BufferedReader in = null;
			
			try {
				in = Files.newBufferedReader(Paths.get("floatingpoint.txt"), StandardCharsets.UTF_8);
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage()); 
		}
	}
	
	public static void fixWithTryWithResources() {
		try (BufferedReader in = 
				Files.newBufferedReader(Paths.get("floatingpoint.txt"), StandardCharsets.UTF_8)) {
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		fixWithFinally();
		fixWithNestedTryFinally();
		fixWithTryWithResources();
	}
}
