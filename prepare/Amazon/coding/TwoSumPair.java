import java.util.*;

public class TwoSumPair {
	// distinct version
	public static int twoSumPair(int[] nums, int target) {
		if (nums.length <= 1) {
			return 0;
		}

		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		for (int num : nums) {
			// check if match a pair
			if (set.contains(target - num)) {
				++count;
			}

			// modify the map
			if (!set.contains(num)) {
				set.add(num);
			}
		}
		return count;
	}

	// duplicate version
	// public static int twoSumPair(int[] nums, int target) {
	// 	if (nums.length <= 1) {
	// 		return 0;
	// 	}

	// 	HashMap<Integer, Integer> map = new HashMap<>();
	// 	int count = 0;
	// 	for (int num : nums) {
	// 		// check if match a pair
	// 		if (map.containsKey(target - num)) {
	// 			count += map.get(target - num);
	// 		}

	// 		// modify the map
	// 		if (!map.containsKey(num)) {
	// 			map.put(num, 1);
	// 		}
	// 		else {
	// 			map.put(num, 1 + map.get(num));
	// 		}
	// 	}
	// 	return count;
	// }

	public static void main(String[] args) {
		// int[] nums = {1, 2, 2, 3};
		int[] nums = {1, 2, 3, 4};
		int target = 5;
		System.out.println(TwoSumPair.twoSumPair(nums, target));
	}
}