// Find Minimum in Rotated Sorted Array Total Accepted: 47686 Total Submissions: 143147 My Submissions Question Solution 
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Hide Tags Array Binary Search

public class FindMin {
    public int findMin(int[] nums) {
        if (nums == null) {
        	return Integer.MIN_VALUE;
        }

        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (nums[mid] <= nums[end]) {
        		end = mid;
        	}
        	else {
        		start = mid;
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