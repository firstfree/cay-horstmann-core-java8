package ch04.exercise.problem4;

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
}
