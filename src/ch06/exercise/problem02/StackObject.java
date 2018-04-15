package ch06.exercise.problem02;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackObject<E> {
	private Object[] array;
	private int index;
	
	public StackObject(int capacity) {
		array = new Object[capacity];
	}

	public void push(E e) {
		if (array.length == index)
			array = Arrays.copyOf(array, array.length + 10);
		array[index++] = e;
	}
	
	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		
		@SuppressWarnings("unchecked")
		E e = (E) array[--index];
		array[index] = null;
		return e;
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
}
