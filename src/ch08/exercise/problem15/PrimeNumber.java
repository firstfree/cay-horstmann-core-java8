package ch08.exercise.problem15;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeNumber {
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			long startTime = System.currentTimeMillis();
			Stream.generate(() -> new BigInteger(168, new Random()))
				.parallel()
				.filter(b -> b.isProbablePrime(10) && b.toString().length() == 50)
				.limit(500)
				.collect(Collectors.toList());
			System.out.println("parallel stream: " + (System.currentTimeMillis() - startTime));
			
			startTime = System.currentTimeMillis();
			Stream.generate(() -> new BigInteger(168, new Random()))
				.filter(b -> b.isProbablePrime(10) && b.toString().length() == 50)
				.limit(500)
				.collect(Collectors.toList());
			System.out.println("stream: " + (System.currentTimeMillis() - startTime));
		}
	}
}
