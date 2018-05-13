package ch08.exercise.problem04;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinearStream {
	public static Stream<Long> createLinearStream(long a, long c, long m, long seed) {
		return Stream.iterate(seed, x -> (a * x + c) % m);
	}
	
	public static void main(String[] args) {
		long a = 25214903917L;
		long c = 11L;
		long m = BigDecimal.valueOf(Math.pow(2, 48)).longValue();
		long seed = 0;
		Stream<Long> linearStream = createLinearStream(a, c, m, seed);
		System.out.println(linearStream.limit(5).collect(Collectors.toList()));
	}
}
