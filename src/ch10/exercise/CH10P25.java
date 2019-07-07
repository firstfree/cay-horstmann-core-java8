package ch10.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CH10P25 {

  public static void main(String[] args) {
    repeat(() -> {
      Scanner in = new Scanner(System.in);
      String userName = in.nextLine();
      char[] password = in.nextLine().toCharArray();
      return new PasswordAuthentication(userName, password);
    }, p -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      return new String(p.getPassword()).equals("secret");
    }).thenAccept(p -> System.out.println(p.getPassword()));

    ForkJoinPool.commonPool().awaitQuiescence(5, TimeUnit.MINUTES);
  }

  public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
    return CompletableFuture.supplyAsync(action)
        .thenApply(p -> until.test(p) ? p : repeat(action, until).join());
  }
}
