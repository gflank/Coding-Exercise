import java.util.*;

public class OverlapRec {
	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean overlapRec(Point topLeft1, Point bottomRight1, Point topLeft2, Point bottomRight2) {
		// judge in the y axis aspect
		if (topLeft1.y <= bottomRight2.y || topLeft2.y <= bottomRight1.y) {
			return false;
		}
		// judge in the x axis aspect
		else if (topLeft1.x >= bottomRight2.x || topLeft2.x >= bottomRight1.x) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		OverlapRec test = new OverlapRec();
		Point topLeft1 = new Point(1, 4);
		Point bottomRight1 = new Point(4, 1);
		Point topLeft2 = new Point(4, 4);
		Point bottomRight2 = new Point(5, 1);
		System.out.println(test.overlapRec(topLeft1, bottomRight1, topLeft2, bottomRight2));
	}
}