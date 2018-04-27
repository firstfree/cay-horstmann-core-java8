package ch07.sec02;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		List<String> friends = new LinkedList<>();
		ListIterator<String> iter = friends.listIterator();
		iter.add("Fred");
		iter.add("Wilma");
		iter.previous();
		iter.set("Barney");
		System.out.println(friends);
	}
}
