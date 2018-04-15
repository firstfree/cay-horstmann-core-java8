package ch06.exercise.problem11;

public class Pair<E> {
	private E first;
	private E second;
	
	public Pair(E first, E second) {
		this.first = first;
		this.second = second;
	}

	public E getFirst() {
		return first;
	}
	
	public E getSecond() {
		return second;
	}
	
	@Override
	public String toString() {
		return "[first=" + first + ",second=" + second + "]";
	}
}
