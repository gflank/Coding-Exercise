import java.util.*;

public class MergeSort {
	public static void sort(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}

	public static void sort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = start + (end - start) / 2;
		sort(nums, start, mid);
		sort(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}

	private static void merge(int[] nums, int start, int mid, int end) {
		int[] copySpace = new int[end - start + 1];
		int left = start, right = mid + 1;
		for (int i = 0; i < copySpace.length; ++i) {
			if (right > end || left < mid + 1 && nums[left] <= nums[right]) {
				copySpace[i] = nums[left++];
			}
			else {
				copySpace[i] = nums[right++];
			}
		}

		// copy back the sorted numbers
		for (int i = 0; i < copySpace.length; ++i) {
			nums[i + start] = copySpace[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = {5, 2, 1, 6, 4};
		MergeSort.sort(nums);
		for (int n : nums) {
			System.out.println(n);
		}
	}
}