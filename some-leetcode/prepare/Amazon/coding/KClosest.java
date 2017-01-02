import java.util.*;

public class KClosest {
	public static class Point {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static Point[] kClosest(Point[] points, int k) {
		if (points.length == 0 || points.length <= k) {
			return points;
		}

		// create a max heap, let the point with largest dis on the top
		PriorityQueue<Point> heap = new PriorityQueue<>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				double diff = getDis(p2) - getDis(p1);
				if (diff > 0) {
					return 1;
				}
				else if (diff < 0) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});

		for (Point p : points) {
			if (heap.size() < k) {
				heap.offer(p);
			}
			else {
				// check if current point need to be put into heap
				if (getDis(p) < getDis(heap.peek())) {
					heap.offer(p);
					// pull out the point with largest distance
					heap.poll();
				}
			}
		}

		// put points into result, with ascending order
		Point[] res = new Point[k];
		int index = k - 1;
		while (index >= 0) {
			res[index] = heap.poll();
			--index;
		}
		return res;
	}

	private static double getDis(Point p) {
		return p.x * p.x +  p.y * p.y;
	}

	public static void main(String[] args) {
		Point[] points = new Point[10];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 2);
		points[2] = new Point(2, 1);
		points[3] = new Point(3, 1);
		points[4] = new Point(4, 1);
		points[5] = new Point(1, 5);
		points[6] = new Point(1, 6);
		points[7] = new Point(7, 1);
		points[8] = new Point(3, 3);
		points[9] = new Point(10, 1);
		Point[] res = KClosest.kClosest(points, 6);
		for (Point p : res) {
			System.out.println(p.x + " " + p.y);
		}
	}
}


// rewrote
// public static Point[] kClosest(Point[] points, int k) {
// 		if (k <= 0) {
// 			return null;
// 		}
// 		else if (points.length <= k) {
// 			return points;
// 		}

// 		PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, new Comparator<Point>() {
// 			public int compare(Point p1, Point p2) {
// 				double dis1 = getDis(p1);
// 				double dis2 = getDis(p2);
// 				if (dis1 == dis2) {
// 					return 0;
// 				}
// 				else if (dis1 > dis2) {
// 					return -1;
// 				}
// 				else {
// 					return 1;
// 				}
// 			}
// 		});

// 		for (Point p : points) {
// 			if (maxHeap.size() < k) {
// 				maxHeap.offer(p);
// 			}
// 			else {
// 				// only put point into heap if it has smaller distance
// 				if (getDis(maxHeap.peek()) > getDis(p)) {
// 					maxHeap.poll();
// 					maxHeap.offer(p);
// 				}
// 			}
// 		}

// 		Point[] res = new Point[k];
// 		for (int i = k - 1; i >= 0; --i) {
// 			res[i] = maxHeap.poll();
// 		}
// 		return res;
// 	}

// 	private static double getDis(Point p) {
// 		return p.x * p.x + p.y * p.y;
// 	}