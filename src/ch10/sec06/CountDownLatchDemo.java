package ch10.sec06;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class CountDownLatchDemo {

  public static AtomicLong count = new AtomicLong();

  public static void main(String[] args) throws InterruptedException {

    CountDownLatch countDown = new CountDownLatch(100);

    ExecutorService executor = Executors.newCachedThreadPool();

    for (int i = 1; i <= 100; ++i) {
      executor.execute(() -> {
        for (int k = 1; k <= 10000000; ++k) {
          count.incrementAndGet();
        }

        countDown.countDown();
      });
    }

    countDown.await();

    System.out.println("Final value: " + count);

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.MINUTES);
  }
}
