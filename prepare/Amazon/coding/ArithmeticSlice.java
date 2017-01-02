import java.util.*;

public class ArithmeticSlice {
	public static int slice(int[] nums) {
		if (nums.length <= 2) {
			return 0;
		}

		int count = 0, gap = Integer.MIN_VALUE, len = 2;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] - nums[i - 1] == gap) {
				++len;
			}
			else {
				// now calculate the possibilities
				gap = nums[i] - nums[i - 1];
				if (len >= 3) {
					count += (len - 2 + 1) * (len - 2) / 2;
					if (count > 1000000000) {
						return -1;
					}
				}
				len = 2;
			}
		}
		if (len >= 3) {
			count += (len - 2 + 1) * (len - 2) / 2;
			if (count > 1000000000) {
				return -1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {-1, 1, 3, 3, 3, 2, 1, 0};
		System.out.println("res: " + ArithmeticSlice.slice(nums));
	}
}