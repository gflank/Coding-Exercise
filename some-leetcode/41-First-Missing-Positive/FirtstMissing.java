// slow version
// public class Solution {
//     public int firstMissingPositive(int[] nums) {
//         if (nums.length == 0) {
//             return 1;
//         }
        
//         int min = Integer.MAX_VALUE;
//         // loop once to get the min/max positive integer
//         for (int i = 0; i < nums.length; ++i) {
//             if (nums[i] > 0) {
//                 if (nums[i] < min) {
//                     min = nums[i];
//                 }
//             }
//         }

//         // loop to move numbers
//         int pos = 0;
//         while (pos < nums.length) {
//             if (nums[pos] < min) {
//                 nums[pos] = -1;
//             }
//             else {
//                 if (nums[pos] <= nums.length && nums[pos] != pos + 1) {
//                     int temp = nums[nums[pos] - 1];
//                     int temp2 = nums[pos];
//                     nums[nums[pos] - 1] = nums[pos];
//                     nums[pos] = temp;
//                     if (temp != temp2) {
//                         continue;
//                     }
//                 }
//             }
//             ++pos;
//         }
        
//         // loop to check exist
//         for (int i = 0; i < nums.length; ++i) {
//             if (nums[i] != i + 1) {
//                 return i + 1;
//             }
//         }
//         return nums.length + 1;
//     }
// }

// -----------------------------------------------------------------------
// improved version
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // loop to rearrange numbers
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                // swap two numbers
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        // loop to check exist
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}