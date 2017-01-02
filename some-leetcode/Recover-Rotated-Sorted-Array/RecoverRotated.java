// LintCode
// Easy Recover Rotated Sorted Array

// 27% Accepted
// Given a rotated sorted array, recover it to sorted array in-place.

// Example
// [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

// Challenge
// In-place, O(1) extra space and O(n) time.

// Clarification
// What is rotated array:

//     - For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

// Tags Expand 
// Sorted Array Array

import java.util.ArrayList;

public class RecoverRotated {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
    	if (nums == null || nums.size() == 0) {
    		return;
    	}

    	int pivot = 0;
    	for (int i = 0; i < nums.size() - 1; ++i) {
    		if (nums.get(i) > nums.get(i + 1)) {
                break;
            }
    		++pivot;
    	}

    	if (pivot == 0) {
    		return;
    	}
    	reverse(nums, 0, pivot);
    	reverse(nums, pivot + 1, nums.size() - 1);
    	reverse(nums, 0 , nums.size() - 1);
    }

    public void reverse(ArrayList<Integer> nums, int start, int end) {
    	int temp;
    	for (int i = start, j = end; i < j; ++i, --j) {
    		temp = nums.get(i);
    		nums.set(i, nums.get(j));
    		nums.set(j, temp);
    	}
    }

    public static void main(String[] args) {
        RecoverRotated A = new RecoverRotated();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(nums);
        A.recoverRotatedSortedArray(nums);
        System.out.println(nums);
    }
 }