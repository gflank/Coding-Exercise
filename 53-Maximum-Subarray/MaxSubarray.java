// Maximum Subarray Total Accepted: 60891 Total Submissions: 176571 My Submissions Question Solution 
// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// click to show more practice.

// More practice:
// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

// Hide Tags Divide and Conquer Array Dynamic Programming

// constant DP
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int prevMax = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            prevMax = Math.max(prevMax + nums[i], nums[i]);
            max = Math.max(max, prevMax);
        }
        
        return max;
    }
}

// public class MaxSubarray {
//     public int maxSubArray(int[] nums) {
//         if (nums == null || nums.length == 0) {
//         	return 0;
//         }

//         int[] table = new int[nums.length];
//         table[0] = nums[0];
//         int max = table[0];
//         for (int i = 1; i < nums.length; ++i) {
//         	table[i] = Math.max(table[i - 1] + nums[i], nums[i]);
//         	if (table[i] > max) {
//         		max = table[i];
//         	}
//         }

//         return max;
//     }
// }
