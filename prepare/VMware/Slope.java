import java.util.*;

public class Slope {
	public static float getNum(int[] xArray, float[] yArray, int n) {
		int start = -1, end = xArray.length;
		for (int i = 0; i < xArray.length; ++i) {
			int cur = xArray[i];
			// equal case
			if (cur == n) {
				return (float)cur;
			}
			else if (cur > n) {
				end = i;
				break;
			}
			else {
				start = i;
			}
		}

		// smaller case
		if (start == -1) {
			start = 0;
			end = 1;
		}
		// larger case
		else if (end == xArray.length) {
			start = xArray.length - 2;
			end = xArray.length - 1;
		}

		// spanning the range
		int[] range = getValidRange(start, end, yArray);
		start = range[0];
		end = range[1];
		// check for valid
		if (start == -1 && end == xArray.length) {
			return 0;
		}
		else if (start == -1) {
			return yArray[end];
		}
		else if (end == xArray.length) {
			return yArray[start];
		}

		float diff = (float)(n - xArray[start]);
		float slope = (yArray[end] - yArray[start]) / (xArray[end] - xArray[start]);
		return diff * slope + yArray[start];
	}

	private static int[] getValidRange(int start, int end, float[] yArray) {
		int[] res = new int[2];
		boolean startFlag = false, endFlag = false;
		if (yArray[start] > 0) {
			res[0] = start;
			startFlag = true;
		}
		if (yArray[end] > 0) {
			res[1] = end;
			endFlag = true;
		}
		if (startFlag && endFlag) return res;

		if (!startFlag) {
			int pos = start - 1;
			while (pos >= 0) {
				if (yArray[pos] > 0) break;
				--pos;
			}
			res[0] = pos;
		}
		if (!endFlag) {
			int pos = end + 1;
			while (pos < yArray.length) {
				if (yArray[pos] > 0) break;
				++pos;
			}
			res[1] = pos;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] ints1 = {10, 20, 50, 100};
		float[] floats1 = {5.33f, 6.85f, 8.9f, 10f};
		System.out.println(Slope.getNum(ints1, floats1, 20));
		System.out.println(Slope.getNum(ints1, floats1, 30));
		System.out.println(Slope.getNum(ints1, floats1, 0));
		System.out.println(Slope.getNum(ints1, floats1, 110));
		System.out.println("");

		int[] ints2 = {10, 20, 50, 100};
		float[] floats2 = {5.33f, 6.85f, 0, 10f};
		System.out.println(Slope.getNum(ints2, floats2, 20));
		System.out.println(Slope.getNum(ints2, floats2, 30));
		System.out.println(Slope.getNum(ints2, floats2, 0));
		System.out.println(Slope.getNum(ints2, floats2, 110));

	}
}