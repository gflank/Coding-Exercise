// House Robber Total Accepted: 18331 Total Submissions: 63557 My Submissions Question Solution 
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Credits:
// Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

// Hide Tags Dynamic Programming

public class HouseRobber {
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
 			// return Math.max(nums[0], nums[1]);
 		}

 		int[] total = new int[nums.length];
 		total[0] = nums[0];
 		total[1] = Math.max(nums[0], nums[1]);

 		for (int i = 2; i < nums.length; ++i) {
 			total[i] = Math.max(total[i - 1], total[i - 2] + nums[i]);
 		}

 		return total[nums.length - 1];
    }
}