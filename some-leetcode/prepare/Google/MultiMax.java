import java.util.*;

public class MultiMax {
	public static int multiMax(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

		if (nums.length <= 1) {
			return -1;
		}
		else if (nums.length == 2) {
			return nums[0] * nums[1];
		}

		for (int n : nums) {
			// save top two biggest nums
			if (n > max1) {
				if (max1 > max2) {
					max2 = max1;
				}
				max1 = n;
			}
			else if (n > max2) {
				max2 = n;
			}

			// save top two smallest nums
			if (n < min1) {
				if (min1 < min2) {
					min2 = min1;
				}
				min1 = n;
			}
			else if (n < min2) {
				min2 = n;
			}
		}

		return Math.max(max1 * max2, min1 * min2);
	}

	public static void main(String[] args) {
		int[] nums = {-8, -7, -3, -1, 0, 5, 6, 9};
		System.out.println(MultiMax.multiMax(nums));

		int[] nums1 = {-1, 0, 9};
		System.out.println(MultiMax.multiMax(nums1));

		int[] nums2 = {-8, -7, -3, -1};
		System.out.println(MultiMax.multiMax(nums2));

		int[] nums3 = {1, 2, 5, 6, 9};
		System.out.println(MultiMax.multiMax(nums3));
	}
}