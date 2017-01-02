import java.util.*;

public class KSub {
	public static long kSub(int[] nums, int k) {
		if (k == 0 || nums.length == 0) {
			return -1;
		}

		int[] modCount = new int[k];
		// initial 0 position to 1, indicating the ranges start with head
		modCount[0] = 1;
		int sum = 0;
		for (int n : nums) {
			sum += n;
			sum %= k;
			// count # of prefix sum with remainder 0 to k - 1 when divide k
			++modCount[sum];
		}

		long res = 0;
		for (int count : modCount) {
			// count of all pairs from prefix sum that have the same remainder
			res += (long)count * (count - 1) / 2;
		}
		return res;
	}

	// slow solution
	// public static int kSub(int[] nums, int k) {
	// 	if (k == 0 || nums.length == 0) {
	// 		return -1;
	// 	}

	// 	int[] prefix = new int[nums.length + 1];
	// 	for (int i = 1; i <= nums.length; ++i) {
	// 		prefix[i] = prefix[i - 1] + nums[i - 1];
	// 	}

	// 	int count = 0;
	// 	// outer loop changes the size of window
	// 	for (int i = 1; i <= nums.length; ++i) {
	// 		// inner loop changes the starting point
	// 		for (int j = i; j <= nums.length; ++j) {
	// 			int curSum = prefix[j] - prefix[j - i];
	// 			if (curSum % k == 0) ++count;
	// 		}
	// 	}
	// 	return count;
	// }

	public static void main(String[] args) {
		int[] test1 = {1, 2, 3, 4, 1};
		int k = 3;
		System.out.println(KSub.kSub(test1, k));
		System.out.println("");

		int[] test2 = {1, 2, 3, 4, 5};
		System.out.println(KSub.kSub(test2, k));
		System.out.println("");

		int[] test3 = {1, 4, 0, 7};
		System.out.println(KSub.kSub(test3, k));
		System.out.println("");
	}
}

// hackerrank version
import java.io.*;
import java.util.*;

public class Solution {
    public static long kSub(int[] nums, int k) {
		if (k == 0 || nums.length == 0) {
			return -1;
		}

		int[] modCount = new int[k];
		modCount[0] = 1;
		int sum = 0;
		for (int n : nums) {
			sum += n;
			sum %= k;
			// count # of prefix sum with remainder 0 to k - 1 when divide k
			++modCount[sum];
		}

		long res = 0;
		for (int count : modCount) {
			// count of all pairs from prefix sum that have the same remainder
			res += (long)count * (count - 1) / 2;
		}
		return res;
	}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        // first get the test case number
        int num_test = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num_test; ++i) {
            // now get the format
            String[] types = sc.nextLine().split(" ");
            int size = Integer.parseInt(types[0]);
            int k = Integer.parseInt(types[1]);
            
            // get the numbers
            int[] nums = new int[size];
            String[] inputNums = sc.nextLine().split(" ");
            for (int j = 0; j < size; ++j) {
                nums[j] = Integer.parseInt(inputNums[j]);
            }
            
            // now call the function
            System.out.println(Solution.kSub(nums, k));
        }
    }
}