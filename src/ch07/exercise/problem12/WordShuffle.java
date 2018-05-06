package ch07.exercise.problem12;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordShuffle {
	public static void main(String[] args) throws IOException {
		System.out.println(shuffleWords("word.txt"));
	}
	
	public static List<String> shuffleWords(String filename) throws IOException {
		List<String> lines = new ArrayList<>();
		int startIndex = 0;
		int numberOfWords = 0;
		
		try (Scanner in = new Scanner(Paths.get(filename))) {
			while (in.hasNext()) {
				String word = in.next();
				lines.add(word);
				
				numberOfWords++;
				
				if (word.contains(".")) {
					Collections.shuffle(lines.subList(startIndex + 1, lines.size() - 1));
					startIndex += numberOfWords;
					numberOfWords = 0;
				}
			}
		}
		
		return lines;
	}
}
