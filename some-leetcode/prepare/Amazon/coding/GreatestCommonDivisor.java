import java.util.*;

public class GreatestCommonDivisor {
	public static int greatest(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		else if (nums.length == 1) {
			return nums[0];
		}

		int divisor = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			// pruning the tail
			if (divisor == 1) {
				return 1;
			}
			divisor = gcd(divisor, nums[i]);
		}
		return divisor;
	}

	// Using Euclid's algorithm
	private static int gcd(int num1, int num2) {
		if (num1 == 0 || num2 == 0) {
			return num1 + num2;
		}
		return gcd(num2, num1 % num2);
	}

	public static void main(String[] args) {
		int[] nums = {1000000008, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 42, 18, 24, 6};
		System.out.println(GreatestCommonDivisor.greatest(nums));
	}
}