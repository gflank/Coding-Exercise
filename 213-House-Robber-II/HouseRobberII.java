// House Robber II Total Accepted: 4284 Total Submissions: 16282 My Submissions Question Solution 
// Note: This is an extension of House Robber.

// After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Credits:
// Special thanks to @Freezen for adding this problem and creating all test cases.

// Hide Tags Dynamic Programming

public class HouseRobberII {
    public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length <= 2) {
 			int max = Integer.MIN_VALUE;
 			for (int i = 0; i < nums.length; ++i) {
 				if (nums[i] > max) {
 					max = nums[i];
 				}
 			}
 			return max;
 		}

		return Math.max(robSub(nums, 0, nums.length - 2), robSub(nums, 1, nums.length - 1));
    }

    private int robSub(int[] nums, int start, int end) {
		int[] total = new int[end + 1 - start];
		total[0] = nums[start];
		total[1] = Math.max(nums[start], nums[start + 1]);

		for (int i = 2; i < end + 1 - start; ++i) {
			total[i] = Math.max(total[i - 1], total[i - 2] + nums[start + i]);
		}

		return total[end - start];
    }
}