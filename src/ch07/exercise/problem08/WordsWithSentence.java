package ch07.exercise.problem08;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordsWithSentence {
	public static void main(String[] args) throws IOException {
		System.out.println(saveSentenceByWord("word.txt"));
	}
	
	public static Map<String, Set<String>> saveSentenceByWord(String filename) throws IOException {
		Map<String, Set<String>> wordsWithSentence = new TreeMap<>();
		
		try (Scanner in = new Scanner(Paths.get(filename))) {
			while (in.hasNextLine()) {
				String sentence = in.nextLine();
				String[] words = sentence.split("\\W+");
				for (String word : words) {
					Set<String> sentences = wordsWithSentence.computeIfAbsent(word, k -> new TreeSet<>());
					sentences.add(sentence);
				}
			}
		}
		
		return wordsWithSentence;
	}
}
