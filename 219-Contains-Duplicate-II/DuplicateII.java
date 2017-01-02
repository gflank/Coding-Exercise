// Contains Duplicate II Total Accepted: 11709 Total Submissions: 45821 My Submissions Question Solution 
// Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

// Hide Tags Array Hash Table

import java.util.*;

public class DuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return false;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int pre;
        for (int i = 0; i < nums.length; ++i) {
        	if (map.containsKey(nums[i])) {
        		pre = map.get(nums[i]);
        		if (i - pre <= k) {
	        		return true;
        		}
        	}
        	map.put(nums[i], i);
        }

        return false;
    }
}