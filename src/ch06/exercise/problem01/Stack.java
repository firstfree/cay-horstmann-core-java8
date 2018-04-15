package ch06.exercise.problem01;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {
	private ArrayList<E> array;
	
	public Stack(int capacity) {
		array = new ArrayList<>(capacity);
	}
	
	public void push(E e) {
		array.add(e);
	}
	
	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		return array.get(array.size() - 1);
	}
	
	public boolean isEmpty() {
		return array.isEmpty();
	}
}
