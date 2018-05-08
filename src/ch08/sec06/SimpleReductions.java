package ch08.sec06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleReductions {
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\PL+"));
		
		Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
		System.out.println("largest: " + largest.orElse(""));
		
		boolean aWordStartsWithQ = words.stream().anyMatch(w -> w.startsWith("Q"));
		System.out.println("aWordStartsWithQ: " + aWordStartsWithQ);
		
		Optional<String> startsWithQ = words.stream().parallel().filter(w -> w.startsWith("Q")).findAny();
		System.out.println("startsWithQ: " + startsWithQ.orElse("(None)"));
	}
}
