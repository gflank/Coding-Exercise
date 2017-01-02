import java.util.*;

public class LongestSubZero {
	public static int[] longest(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0, maxLen = Integer.MIN_VALUE;
		int start = -1;
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(-nums[i])) {
				int prevI = map.get(-nums[i]) + 1;
				int curLen = i - prevI + 1;
				if (curLen > maxLen) {
					maxLen = curLen;
					start = prevI;
				}
			}
			sum += nums[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		// if not found
		if (start == -1) {
			return null;
		}
		int[] res = new int[maxLen];
		for (int i = 0; i < maxLen; ++i) {
			res[i] = nums[i + start];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test1 = {4, 8, 3, -7, -4, 8};
		int[] res1 = LongestSubZero.longest(test1);
		for (int r : res1) {
			System.out.printf("%d ", r);
		}
		System.out.println("");
	}
}