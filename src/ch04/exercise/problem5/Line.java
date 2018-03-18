package ch04.exercise.problem5;

public class Line extends Shape {
	private Point to;
	
	public Line(Point from, Point to) {
		super(from);
		this.to = to;
	}
	
	@Override
	public Point getCenter() {
		return new Point((point.getX() + to.getX()) / 2, (point.getY() + to.getY()) / 2);
	}
	
	@Override
	public void moveBy(double dx, double dy) {
		super.moveBy(dx, dy);
		to = new Point(to.getX() + dx, to.getY() + dy);
	}
	
	@Override
	public Line clone() {
		try {
			Line cloned = (Line) super.clone();
			cloned.to = to.clone();
			return cloned;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
