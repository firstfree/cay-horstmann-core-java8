package ch04.exercise.problem9;

public class Book {
	private String author;
	private String name;
	private double price;
	
	public Book(String author, String name, double price) {
		this.author = author;
		this.name = name;
		this.price = price;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
	
	public static void main(String[] args) {
		System.out.println(new Book("mike", "love", 20));
	}
}
