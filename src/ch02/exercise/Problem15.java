package ch02.exercise;

import java.util.ArrayList;

public class Problem15 {

	public static void main(String[] args) {
		Invoice invoice = new Invoice();
		invoice.addItem("a", 4, 2.0);
		invoice.addItem("b", 2, 17.9);
		invoice.print();
	}

	public static class Invoice {

		private static class Item {
			String description;
			int quantity;
			double unitPrice;

			double price() {
				return quantity * unitPrice;
			}

			@Override
			public String toString() {
				return description + "\t구매수:" + quantity + "\t1개당 가격:" + unitPrice + "\t가격:" + price();
			}
		}

		private ArrayList<Item> items = new ArrayList<>();

		public void addItem(String description, int quantity, double unitPrice) {
			Item newItem = new Item();
			newItem.description = description;
			newItem.quantity = quantity;
			newItem.unitPrice = unitPrice;
			items.add(newItem);
		}

		public void print() {
			double total = 0;
			for (Item item : items) {
				System.out.println(item);
				total += item.price();
			}

			System.out.println("총가격:" + total);
		}
	}
}
