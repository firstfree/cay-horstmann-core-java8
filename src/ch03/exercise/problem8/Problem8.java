package ch03.exercise.problem8;

public class Problem8 {

	public static void main(String[] args) {
		Runnable r1 = new Greeter(5, "Satoshi");
		Runnable r2 = new Greeter(10, "Patrick");
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
