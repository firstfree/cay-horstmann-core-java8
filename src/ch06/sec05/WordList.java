package ch06.sec05;

import java.util.ArrayList;
import java.util.Arrays;

public class WordList extends ArrayList<String> {
	private static final long serialVersionUID = 1L;
	
	public boolean add(String e) {
		return isBadWord(e) ? false : super.add(e);
	}
	
	public String get(int i) {
		return super.get(i).toLowerCase();
	}
	
	public static boolean isBadWord(String s) {
		return Arrays.asList("sed", "drugs", "c++").contains(s.toLowerCase());
	}
}
