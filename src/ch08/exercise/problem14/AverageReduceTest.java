package ch08.exercise.problem14;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AverageReduceTest {
	public static void main(String[] args) {
		AtomicInteger count = new AtomicInteger();
		Stream<Double> doubles = Stream.of(1.0d, 2.0d, 3.0d, 3.2d, 2.25d);
		double sum = doubles.reduce(0d, (x, y) -> {
			count.incrementAndGet();
			return x + y;
		});
		
		System.out.println(sum / count.get());
	}
}
