package ch04.exercise.problem2;

import java.util.Objects;

public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "[x=" + x + ",y=" + y + "]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == this) {
			return true;
		}
		
		if (otherObject == null) {
			return false;
		}
		
		if (otherObject.getClass() != getClass()) {
			return false;
		}
		
		Point other = (Point) otherObject;
		
		return (Double.compare(other.getX(), x) == 0) && (Double.compare(other.getY(), y) == 0);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
