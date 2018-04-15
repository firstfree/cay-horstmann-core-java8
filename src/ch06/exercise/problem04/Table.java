package ch06.exercise.problem04;

import java.util.ArrayList;

public class Table<K, V> {
	private ArrayList<Entry> entries;
	
	public Table(int capacity) {
		entries = new ArrayList<>(capacity);
	}
	
	public V getValue(K key) {
		Entry entry = get(key);
		return entry == null ? null : entry.getValue();
	}
	
	public void setValue(K key, V value) {
		Entry entry = get(key);
		if (entry == null)
			entries.add(new Entry(key, value));
		else
			entry.setValue(value);
	}
	
	public Entry remove(K key) {
		Entry entry = get(key);
		entries.remove(entry);		
		return entry;
	}
	
	private Entry get(K key) {
		for (Entry entry : entries) {
			if (entry.getKey().equals(key))
				return entry;
		}
		
		return null;
	}
	
	public class Entry {
		private K key;
		private V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
		
		public V getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			return "[key=" + key + ",value=" + value + "]";
		}
	}
}
