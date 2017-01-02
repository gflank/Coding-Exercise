// Single Number Total Accepted: 74646 Total Submissions: 165559 My Submissions Question Solution 
// Given an array of integers, every element appears twice except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Hide Tags Hash Table Bit Manipulation

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 0 || nums == null) {
        	return 0;
        }

        int single = nums[0];
        for (int i = 1; i < nums.length; ++i) {
        	single = single ^ nums[i];
        }

        return single;
    }
}
