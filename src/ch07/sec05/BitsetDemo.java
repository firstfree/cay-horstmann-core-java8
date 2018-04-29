package ch07.sec05;

import java.util.BitSet;

public class BitsetDemo {
	public static void main(String[] args) {
		int n = 100000;
		BitSet primes = new BitSet(n + 1);
		for (int i = 0; i <= n; ++i)
			primes.set(i);
		for (int i = 2; i * i <= n; ++i) {
			if (primes.get(i)) {
				for (int k = i * 2; k <= n; k += i)
					primes.clear(k);
			}
		}
		
		System.out.println(primes);
	}
}
