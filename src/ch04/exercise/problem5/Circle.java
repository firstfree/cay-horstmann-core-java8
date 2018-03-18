package ch04.exercise.problem5;

public class Circle extends Shape {
	private double radius;
	
	public Circle(Point center, double radius) {
		super(center);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	@Override
	public Point getCenter() {
		return new Point(point.getX(), point.getY());
	}
	
	@Override
	public Circle clone() {
		try {
			return (Circle) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
