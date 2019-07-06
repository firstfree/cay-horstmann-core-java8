package ch10.exercise;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CH10P07 {

  public static void main(String[] args) {
    ConcurrentHashMap<String, Long> numbers = new ConcurrentHashMap<>();

    new Random().longs(10000000, 0, 100000000)
        .forEach(number -> numbers.put(number + "", number));

    String keyOfMaximumNumber = numbers
        .reduceEntries(1000000, (e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2)
        .getKey();

    System.out.println(keyOfMaximumNumber);
  }
}
