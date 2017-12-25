package ch03.sec03;

public class RunnableDemo {

	public static void main(String[] args) {
		new Thread(new HelloTask()).start();
		System.out.println("Thread started");
	}
}

class HelloTask implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Hello, World!");
		}
	}
}
