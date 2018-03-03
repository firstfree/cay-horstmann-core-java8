package ch03.exercise.problem13;

public class Problem13 {

	public static Runnable run(Runnable... runnables) {
		return () -> {
			for (Runnable runnable : runnables) {
				runnable.run();
			}
		};
	}
	
	public static void main(String[] args) {
		run(() -> System.out.println("a"),
			() -> System.out.println("b"),
			() -> System.out.println("c"),
			() -> System.out.println("d"),
			() -> System.out.println("e")).run();
	}
}
