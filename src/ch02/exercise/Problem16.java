package ch02.exercise;

import java.util.ArrayList;
import java.util.List;

public class Problem16 {

	public static void main(String[] args) {

		Queue queue = new Queue();

		queue.add(new Queue.Node("a"));
		queue.add(new Queue.Node("b"));
		queue.add(new Queue.Node("c"));
		queue.add(new Queue.Node("d"));

		queue.print();

		queue.remove();

		queue.print();
	}

	public static class Queue {

		private List<Node> nodes = new ArrayList<>();

		public void add(Node node) {
			nodes.add(node);
		}

		public Node remove() {
			if (nodes.size() == 0) {
				return null;
			}

			return nodes.remove(0);
		}

		public void print() {
			System.out.println(nodes);
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
