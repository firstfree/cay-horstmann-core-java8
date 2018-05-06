package ch07.exercise.problem13;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cache<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = -8519923493945095470L;
	
	private int initialCapacity;
	
	public Cache(int initialCapacity) {
		super(initialCapacity);
		this.initialCapacity = initialCapacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		return size() > initialCapacity;
	}

	public static void main(String[] args) {
		Map<String, Integer> cache = new Cache<>(5);
		cache.put("a", 1);
		cache.put("b", 2);
		cache.put("c", 3);
		cache.put("d", 4);
		cache.put("e", 5);
		System.out.println(cache);
		
		cache.put("f", 6);
		System.out.println(cache);
	}
}
