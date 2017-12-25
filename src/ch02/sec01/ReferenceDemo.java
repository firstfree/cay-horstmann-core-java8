package ch02.sec01;

import java.util.ArrayList;

public class ReferenceDemo {
	public static void main(String[] args) {
		ArrayList<String> friends = new ArrayList<>();
		friends.add("Peter");
		
		ArrayList<String> people = friends;
		people.add("Paul");
		
		System.out.println(friends);
	}
}
