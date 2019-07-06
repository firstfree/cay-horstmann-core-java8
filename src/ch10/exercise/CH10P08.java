package ch10.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class CH10P08 {

  public static final AtomicLong atomicCounter = new AtomicLong();
  public static final LongAdder adderCounter = new LongAdder();

  public static void main(String[] args) throws InterruptedException {
    int processors = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newFixedThreadPool(processors);

    List<Callable<Long>> tasks = new ArrayList<>();
    for (int i = 0; i < 1000; ++i) {
      tasks.add(() -> {
        for (int k = 0; k < 100000; ++k) {
//          atomicCounter.incrementAndGet();
          adderCounter.increment();
        }

//        return atomicCounter.longValue();
        return adderCounter.longValue();
      });
    }

    long startTime = System.currentTimeMillis();

    executor.invokeAll(tasks);

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.MINUTES);

    System.out.println(adderCounter);
    System.out.println("elapsed time: " + (System.currentTimeMillis() - startTime));
  }
}
