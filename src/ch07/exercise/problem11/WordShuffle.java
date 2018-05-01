package ch07.exercise.problem11;

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
		List<String> words = new ArrayList<>();
		
		try (Scanner in = new Scanner(Paths.get(filename))) {
			while (in.hasNext()) {
				String word = in.next().replaceAll("\\W", "");
				if (!word.isEmpty()) {
					words.add(word);
				}
			}
		}

		Collections.shuffle(words.subList(1, words.size() - 1));
		
		return words;
	}
}
