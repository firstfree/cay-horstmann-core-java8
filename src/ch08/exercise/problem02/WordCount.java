package ch08.exercise.problem02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WordCount {
	public static void main(String[] args) throws IOException, InterruptedException {
		String contents = new String(Files.readAllBytes(Paths.get("war_and_peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\PL+"));
		
		for (int i = 0; i < 10; ++i) {
			long startTime = System.currentTimeMillis();
			words.stream().filter(w -> w.length() > 8).count();
			System.out.println("stream: " + (System.currentTimeMillis() - startTime));
			
			startTime = System.currentTimeMillis();
			words.parallelStream().filter(w -> w.length() > 8).count();
			System.out.println("parallel stream: " + (System.currentTimeMillis() - startTime));
		}
	}
}
