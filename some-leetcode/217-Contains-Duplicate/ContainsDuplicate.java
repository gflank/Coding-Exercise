// Contains Duplicate Total Accepted: 15549 Total Submissions: 43468 My Submissions Question Solution 
// Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

// Hide Tags Array Hash Table

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    	if (nums.length == 0 || nums == null) {
    		return false;
    	}

    	Set<Integer> hash = new HashSet<Integer>();
    	for (int i : nums) {
    		if (hash.contains(i)) {
    			return true;
    		}
    		else {
    			hash.add(i);
    		}
    	}

    	return false;
    }
}
