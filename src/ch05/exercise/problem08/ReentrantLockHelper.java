package ch05.exercise.problem08;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHelper extends ReentrantLock implements AutoCloseable {
	private static final long serialVersionUID = 1L;

	private static final ReentrantLockHelper helper = new ReentrantLockHelper();
	
	@Override
	public void close() {
		this.unlock();
	}
	
	public static ReentrantLockHelper getReentrantLock() {
		helper.lock();
		return helper;
	}
	
	public static void main(String[] args) {
		Runnable runnable = () -> {
			try (ReentrantLockHelper helper = ReentrantLockHelper.getReentrantLock()) {
				for (int i = 0; i < 100; ++i) {
					try {
						Thread.sleep(10);
						System.out.println(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(runnable).start();
		new Thread(runnable).start();
	}
}
