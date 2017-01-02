import java.util.*;

public class SlidingSum {
	public static int[] slidingSum(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k) {
			return new int[0];
		}

		int[] res = new int[nums.length - k + 1];
		int sum = 0;
		int start = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (i >= k) {
				// now need to pop out the earliest value out of window
				sum -= nums[start];
				++start;
			}
			// add current value to the sum
			sum += nums[i];
			
			if (i >= k - 1) {
				// put sum into res
				res[i - k + 1] = sum;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int k = 3;
		int[] res = SlidingSum.slidingSum(nums, k);
		for (int num : res) {
			System.out.println(num);
		}
	}
}