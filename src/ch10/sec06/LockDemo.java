package ch10.sec06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

  private static int count;
  private static Lock lock = new ReentrantLock();

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newCachedThreadPool();

    for (int i = 1; i <= 100; ++i) {
      Runnable task = () -> {
        for (int k = 1; k <= 1000; ++k) {
          lock.lock();
          try {
            count++;
          } finally {
            lock.unlock();
          }
        }
      };

      executor.execute(task);
    }

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.MINUTES);
    System.out.println("Final value " + count);
  }
}
