package ch07.sec05;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
	public static void main(String[] args) throws InterruptedException {
		WeakHashMap<String, Integer> weaks = new WeakHashMap<>();
		String key = new String("a");
		weaks.put(key, 1);
		
		execute(weaks);
		key = null;
		execute(weaks);
	}
	
	public static void execute(WeakHashMap<String, Integer> weaks) throws InterruptedException {
		for (int i = 0; i < 3; ++i) {
			Thread.sleep(500);
			System.gc();
			System.out.println(weaks);
		}
	}
}
