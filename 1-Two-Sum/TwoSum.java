// rewrote O(n) version
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            else {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                }
            }
        }
        return res;
    }
}

// import java.util.*;

// public class TwoSum {
//     // public int[] twoSum(int[] nums, int target) {
//     // 	int index1 = 0, index2 = 0;
//     // 	for (int i = 0; i < nums.length; ++i) {
//     // 		for (int j = 0; j < nums.length; ++j) {
//     // 			if (nums[i] + nums[j] == target && i != j) {
//     // 				index1 = i + 1;
//     // 				index2 = j + 1;
// 			 //    	int[] result = {index1, index2};
// 	   //  			return result;
//     // 			}
//     // 		}
//     // 	}

//     // 	int[] result = {};
//     // 	return result;
//     // }

// 	// smarter version (sort the array first, then use two pointers)
//     public int[] twoSum(int[] nums, int target) {
//     	int index1 = 0, index2 = 0;
//         HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
//         // save the index into map first
//         for (int i = 1; i <= nums.length; ++i) {
//             if (indexMap.containsKey(nums[i - 1])) {
//                 if (nums[i - 1] * 2 == target) {
//                     index1 = indexMap.get(nums[i - 1]);
//                     index2 = i;
//                     int[] result = {index1, index2};
//                     return result;
//                 }
//             }
//             else {
//                 indexMap.put(nums[i - 1], i);
//             }
//         }
//         Arrays.sort(nums);
// 		for (int i = 0, j = nums.length - 1; i < j;) {
// 			if (nums[i] + nums[j] == target) {
// 				index1 = indexMap.get(nums[i]);
// 				index2 = indexMap.get(nums[j]);
// 		    	int[] result = {index1, index2};
//                 Arrays.sort(result);
//     			return result;
// 			}
// 			else if (nums[i] + nums[j] > target) {
// 				--j;
// 			}
// 			else {
// 				++i;
// 			}
// 		}

//     	int[] result = {};
//     	return result;
//     }

//     public static void main(String[] args) {
//     	TwoSum A= new TwoSum();
//     	// int[] nums = {2, 7, 11, 15};
//     	// int target = 13;
//         // int[] nums = {3, 2, 4};
//         // int target = 6;
//         int[] nums = {0, 3, 2, 0};
//         int target = 0;
//     	int[] result;
//     	result = A.twoSum(nums, target);
//     	for (int i = 0; i < result.length; ++i) {
//     		System.out.printf("%d\n", result[i]);
//     	}
//     }
// }