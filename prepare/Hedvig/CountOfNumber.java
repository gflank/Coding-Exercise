// Count of Number with no consecutive 1's

import java.util.*;

public class CountOfNumber {
	public int count(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 2;
		}
		else if (n == 2) {
			return 3;
		}

		int prev = 3, pPrev = 2, res = 0;
		for (int i = 3; i <= n; ++i) {
			res = prev + pPrev;
			pPrev = prev;
			prev = res;
		}

		return res;
	}

	public static void main(String[] args) {
		CountOfNumber test = new CountOfNumber();
		System.out.println(test.count(6));
	}
}