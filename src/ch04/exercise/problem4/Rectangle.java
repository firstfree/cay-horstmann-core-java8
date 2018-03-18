package ch04.exercise.problem4;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(Point topLeft, double width, double height) {
		super(topLeft);
		this.width = width;
		this.height = height;
	}

	@Override
	public Point getCenter() {
		return new Point(point.getX() + width / 2, point.getY() - height / 2);
	}
}
