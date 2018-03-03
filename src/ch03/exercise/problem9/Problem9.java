package ch03.exercise.problem9;

public class Problem9 {

	public static void runTogether(Runnable... tasks) {
		for (Runnable task : tasks) {
			new Thread(task).start();
		}
		
	}
	
	public static void runInOrder(Runnable... tasks) {
		for (Runnable task : tasks) {
			task.run();
		}
	}
	
	public static void main(String[] args) {
		Runnable task = () -> {
			try {
				Thread.sleep(1000);
				System.out.println("task");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		runTogether(task, task);
		runInOrder(task, task);
	}
}
