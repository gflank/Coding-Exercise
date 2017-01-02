// Rotate Array Total Accepted: 18209 Total Submissions: 103653 My Submissions Question Solution 
// Rotate an array of n elements to the right by k steps.

// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

// [show hint]

// Hint:
// Could you do it in-place with O(1) extra space?
// Related problem: Reverse Words in a String II

// Credits:
// Special thanks to @Freezen for adding this problem and creating all test cases.

// Hide Tags Array

public class RotateArray {
    public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
    		return;
    	}

    	k = k % nums.length;
    	k = nums.length - k;

    	reverse(nums, 0, k - 1);
    	reverse(nums, k, nums.length - 1);
    	reverse(nums, 0 , nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
    	int temp;
    	for (int i = start, j = end; i < j; ++i, --j) {
    		temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
    	}
    }

    public static void main(String[] args) {
        RotateArray A = new RotateArray();
        // int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums = {1, 2};
        for (int i : nums) {
	        System.out.println(i);
        }
        A.rotate(nums, 0);
        for (int i : nums) {
	        System.out.println(i);
        }
    }
}