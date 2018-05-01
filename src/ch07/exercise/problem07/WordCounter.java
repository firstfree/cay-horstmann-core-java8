package ch07.exercise.problem07;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {
	public static void main(String[] args) throws IOException {
		System.out.println(count("word.txt"));
	}
	
	public static Map<String, Integer> count(String filename) throws IOException {
		Map<String, Integer> wordCounts = new TreeMap<>();
		
		try (Scanner in = new Scanner(Paths.get(filename))) {
			while (in.hasNext()) {
				String word = in.next().replaceAll("\\W", "");
				if (!word.isEmpty())
					wordCounts.merge(word, 1, Integer::sum);
			}
		}
		
		return wordCounts;
	}
}
