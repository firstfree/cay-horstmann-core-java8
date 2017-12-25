package ch03.sec03;

import java.util.Arrays;
import java.util.Comparator;

public class SortDemo {

	public static void main(String[] args) {
		String[] friends = new String[] { "Elizabeth", "Wayne", "Zlatan" };
		
		Arrays.sort(friends);

		System.out.println(Arrays.toString(friends));
		
		Arrays.sort(friends, new LengthComparator());

		System.out.println(Arrays.toString(friends));
	}
}

class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String first, String second) {
		return first.length() - second.length();
	}
}
