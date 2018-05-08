package ch08.sec08;

import java.util.Iterator;
import java.util.stream.Stream;

public class CollectingResults {
	public static void main(String[] args) {
		Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
