package ch03.exercise.problem5;

@FunctionalInterface
public interface IntSequence {
	
	int next();

	default boolean hasNext() {
		return true;
	}
	
	static IntSequence constant(int number) {
		return () -> number;
	}
}
