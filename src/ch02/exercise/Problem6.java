package ch02.exercise;

public class Problem6 {

	public static void main(String[] args) {

		Point p = new Point(3, 4).translate(1, 3).scale(0.5);
		System.out.println(p.getX() + ", " + p.getY());
	}

	/**
	 * Point 클래스 (변경자)
	 * 
	 * @author jso
	 * @version 1.1
	 */
	public static final class Point {

		private double x;
		private double y;

		/**
		 * Point 생성자
		 * 
		 * @param x point의 x축 좌표
		 * @param y point의 y축 좌표
		 */
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * Point 이동
		 * 
		 * @param x x축 이동 거리
		 * @param y y축 이동 거리
		 * @return x, y 만큼 이동시킨 point 반환
		 */
		public Point translate(double x, double y) {
			this.x += x;
			this.y += y;
			return this;
		}

		/**
		 * Point 크기 변경
		 * 
		 * @param scale 변경할 크기
		 * @return scale 만큼 변경한 point 반환
		 */
		public Point scale(double scale) {
			this.x *= scale;
			this.y *= scale;
			return this;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}
	}
}
