package ch02.sec06;

import java.util.ArrayList;

/**
 * <code>Invoice</code> 객체는 각 주문 항목에 해당하는 품목명을 포함하는 청구서를 표현한다.
 * 
 * @author jso
 * @author 프레드 프린스톤
 * @author 바니 러블
 * @version 1.1
 */
public class Invoice {

	private static class Item {
		String description;
		int quantity;
		double unitPrice;

		double price() {
			return quantity * unitPrice;
		}

		@Override
		public String toString() {
			return quantity + " x " + description + " @ $" + unitPrice + " each";
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

	/**
	 * {@link ch02.sec04.Employee#raiseSalary(double)} is good.
	 * @see ch02.sec04.Employee#raiseSalary(double)
	 * @see <a href="https://www.google.co.kr">Google</a>
	 * @see "Core Java for the Impatient"
	 */
	public void print() {
		double total = 0;
		for (Item item : items) {
			System.out.println(item);
			total += item.price();
		}

		System.out.println(total);
	}

	/**
	 * @param on if on true, else false
	 * @deprecated Use <code>setVisible(true)</code> instead
	 */
	@Deprecated
	public void onVisible(boolean on) {
	}
}
