package ch07.exercise.problem01;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SieveOfErathostenes {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n  = in.nextInt();
			
			System.out.println(getHashPrimes(n));
			System.out.println(getBitPrimes(n));
		}
	}
	
	public static Set<Integer> getHashPrimes(int n) {
		Set<Integer> primes = new HashSet<>(n - 1);
		for (int i = 2; i <= n; ++i) {
			primes.add(i);
		}
		
		for (int i = 2; i * i <= n; ++i) {
			if (primes.contains(i)) {
				for (int j = i * 2; j <= n; j += i) {
					primes.remove(j);
				}
			}
		}
		
		return primes;
	}
	
	public static BitSet getBitPrimes(int n) {
		BitSet primes = new BitSet(n - 1);
		for (int i = 2; i <= n; ++i) {
			primes.set(i);
		}
		
		for (int i = 2; i * i <= n; ++i) {
			if (primes.get(i)) {
				for (int j = i * 2; j <= n; j += i) {
					primes.clear(j);
				}
			}
		}
		
		return primes;
	}
}
