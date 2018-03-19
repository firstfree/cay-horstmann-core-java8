package ch04.exercise.problem6;

import java.util.Objects;

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
		
		if (otherObject.getClass() == Item.class) {
			return true;
		}
		
		DiscountedItem other = (DiscountedItem) otherObject;
		
		return Double.compare(discount, other.discount) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), discount);
	}
	
	public static void main(String[] args) {
		DiscountedItem x = new DiscountedItem("a", 1, 1);
		Item y = new Item("a", 1);
		DiscountedItem z = new DiscountedItem("a", 1, 2);
		
		System.out.println(x.equals(y));
		System.out.println(y.equals(z));
		System.out.println(x.equals(z));
	}
}
