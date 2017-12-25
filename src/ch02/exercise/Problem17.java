package ch02.exercise;

import java.util.ArrayList;
import java.util.List;

import ch02.exercise.Problem17.Queue.Iterator;

public class Problem17 {

	public static void main(String[] args) {

		Queue queue = new Queue();

		queue.add(new Queue.Node("a"));
		queue.add(new Queue.Node("b"));
		queue.add(new Queue.Node("c"));
		queue.add(new Queue.Node("d"));

		Iterator it = queue.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static class Queue {

		private List<Node> nodes = new ArrayList<>();

		public void add(Node node) {
			nodes.add(node);
		}

		public Node remove() {
			return nodes.remove(0);
		}

		public Iterator iterator() {
			return new Iterator();
		}

		public void print() {
			System.out.println(nodes);
		}

		public class Iterator {
			public boolean hasNext() {
				return !nodes.isEmpty();
			}

			public Node next() {
				return remove();
			}
		}

		public static class Node {
			private String data;

			public Node(String data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return "Node [data=" + data + "]";
			}
		}
	}
}
