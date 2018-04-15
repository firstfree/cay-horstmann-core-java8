package ch06.exercise.problem02;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.function.IntFunction;

public class StackGeneric<E> {
	private E[] array;
	private int index;
	
	public StackGeneric(int capacity, IntFunction<E[]> constr) {
		array = constr.apply(capacity);
	}
	
	public void push(E e) {
		if (array.length == index)
			array = Arrays.copyOf(array, array.length + 10);
		array[index++] = e;
	}
	
	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		
		E e = array[--index];
		array[index] = null;
		return e;
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
	public int length() {
		return array.length;
	}
}
