package ch04.sec01;

public class ConcurrentWorker extends Worker {

	@Override
	public void work() {
		Thread t = new Thread(super::work);
		t.start();
	}
}
