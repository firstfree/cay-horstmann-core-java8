package ch08.sec01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = new ArrayList<>(Arrays.asList(contents.split("\\PL+")));
		
		long count = 0;
		for (String word : words) {
			if (word.length() > 12) {
				count++;
			}
		}
		System.out.println(count);
		
		count = words.stream().filter(w -> w.length() > 12).count();
		System.out.println(count);
		
		count = words.parallelStream().filter(w -> w.length() > 12).count();
		System.out.println(count);
	}
}
