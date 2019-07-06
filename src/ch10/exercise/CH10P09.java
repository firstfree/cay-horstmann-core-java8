package ch10.exercise;

import java.util.concurrent.atomic.LongAccumulator;

public class CH10P09 {

  public static void main(String[] args) {
    LongAccumulator counter = new LongAccumulator(Math::max, 0);
    counter.accumulate(10);
    counter.accumulate(20);
    counter.accumulate(15);

    System.out.println(counter.get());
  }
}
