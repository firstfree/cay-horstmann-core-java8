package ch07.exercise.problem09;

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
				if (!word.isEmpty()) {
//					wordCounts.merge(word, 1, Integer::sum);
//					countByContainsKey(wordCounts, word);
//					countByGetAndNull(wordCounts, word);
//					countByGetOrDefault(wordCounts, word);
					countByPutIfAbsent(wordCounts, word);
				}
			}
		}
		
		return wordCounts;
	}
	
	private static void countByContainsKey(Map<String, Integer> wordCounts, String word) {
		int count = 1;
		if (wordCounts.containsKey(word)) {
			count += wordCounts.get(word);
		}
		
		wordCounts.put(word, count);
	}
	
	private static void countByGetAndNull(Map<String, Integer> wordCounts, String word) {
		int count = 1;
		if (wordCounts.get(word) != null) {
			count += wordCounts.get(word);
		}
		
		wordCounts.put(word, count);
	}
	
	private static void countByGetOrDefault(Map<String, Integer> wordCounts, String word) {
		wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
	}
	
	private static void countByPutIfAbsent(Map<String, Integer> wordCounts, String word) {
		Integer count = wordCounts.putIfAbsent(word, 1);
		if (count != null) {
			wordCounts.put(word, count + 1);
		}
	}
}
