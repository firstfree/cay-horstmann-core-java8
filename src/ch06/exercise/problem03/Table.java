package ch06.exercise.problem03;

import java.util.ArrayList;

public class Table<K, V> {
	private ArrayList<Entry<K, V>> entries;
	
	public Table(int capacity) {
		entries = new ArrayList<>(capacity);
	}
	
	public V getValue(K key) {
		Entry<K, V> entry = get(key);
		return entry == null ? null : entry.getValue();
	}
	
	public void setValue(K key, V value) {
		Entry<K, V> entry = get(key);
		if (entry == null)
			entries.add(new Entry<>(key, value));
		else
			entry.setValue(value);
	}
	
	public Entry<K, V> remove(K key) {
		Entry<K, V> entry = get(key);
		entries.remove(entry);
		return entry;
	}
	
	private Entry<K, V> get(K key) {
		for (Entry<K, V> entry : entries) {
			if (entry.getKey().equals(key))
				return entry;
		}
		
		return null;
	}
}
