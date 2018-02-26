package ch03.exercise.problem6;

public class Problem6 {

	public static void main(String[] args) {
		DigitSequence digitSequence = new DigitSequence(101);
		digitSequence.forEachRemaining(System.out::println);
		digitSequence.remove();
	}
}
