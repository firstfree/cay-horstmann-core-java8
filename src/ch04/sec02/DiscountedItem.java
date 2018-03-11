package ch04.sec02;

public class DiscountedItem extends Item {
	private double discount;

	public DiscountedItem(String description, double price, double discount) {
		super(description, price);
		this.discount = discount;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		
		DiscountedItem other = (DiscountedItem) otherObject;
		
		return discount == other.discount;
	}
	
	public static void main(String[] args) {
		DiscountedItem discountedItem = new DiscountedItem("aa", 1, 1);
		Item item = new Item("aa", 1);
		System.out.println(item.equals(discountedItem));
	}
}
