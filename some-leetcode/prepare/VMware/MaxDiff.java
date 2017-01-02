import java.util.*;

public class MaxDiff {
	public static int maxDiff(int[] nums) {
		if (nums.length <= 1) {
			return -1;
		}

		int min = nums[0];
		int diff = 0;
		for (int n : nums) {
			diff = Math.max(n - min, diff);
			min = Math.min(n, min);
		}
		return diff != 0? diff : -1;
	}

	public static void main(String[] args) {
		int[] test1 = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(MaxDiff.maxDiff(test1));
		System.out.println("");

		int[] test2 = {7, 9, 5, 6, 3, 2};
		System.out.println(MaxDiff.maxDiff(test2));
		System.out.println("");

		int[] test3 = {80, 2, 6, 3, 100};
		System.out.println(MaxDiff.maxDiff(test3));
		System.out.println("");

		int[] test4 = {1, 2, 6, 80, 100};
		System.out.println(MaxDiff.maxDiff(test4));
	}
}