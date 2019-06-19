package ch10.sec06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlagDemo {

  private static Flag flag = new Flag();

  public static void main(String[] args) {
    Runnable hellos = () -> {
      for (int i = 1; i <= 1000; ++i) {
        System.out.println("Hello " + i);
      }
      flag.set();
    };

    Runnable goodbye = () -> {
      int i = 1;
      while (!flag.get()) {
        i++;
      }
      System.out.println("Goodbye " + i);
    };

    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(hellos);
    executor.execute(goodbye);
  }
}
