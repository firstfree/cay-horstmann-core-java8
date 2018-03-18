package ch04.exercise.problem5;

public abstract class Shape implements Cloneable {
	protected Point point;

	public Shape(Point point) {
		this.point = point;
	}
	
	public void moveBy(double dx, double dy) {
		point = new Point(point.getX() + dx, point.getY() + dy);
	}
	
	public abstract Point getCenter();
	
	@Override
	public Shape clone() throws CloneNotSupportedException {
		Shape cloned = (Shape) super.clone();
		cloned.point = point.clone();
		return cloned;
	}
}
