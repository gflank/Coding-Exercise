// Find Minimum in Rotated Sorted Array II Total Accepted: 28449 Total Submissions: 89069 My Submissions Question Solution 
// Follow up for "Find Minimum in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// The array may contain duplicates.

// Hide Tags Array Binary Search

public class FindMinII {
    public int findMin(int[] nums) {
        if (nums == null) {
        	return Integer.MIN_VALUE;
        }

        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (nums[mid] == nums[end]) {
        		--end;
        	}
        	else if (nums[mid] > nums[end]) {
        		start = mid;
        	}
        	else {
        		end = mid;
        	}
        }

        if (nums[start] < nums[end]) {
        	return nums[start];
        }
        else {
        	return nums[end];
        }
    }
}
