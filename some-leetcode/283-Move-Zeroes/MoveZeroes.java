public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        
        int count = 0; // how many non-zero
        for (int i = 0; i < len; ++i) {
            if (nums[i] != 0) {
                // only copy and set when not at same position
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                ++count;
            }
        }
    }
}


// public class Solution {
//     public void moveZeroes(int[] nums) {
//         int len = nums.length;
//         if (len <= 1) {
//             return;
//         }
        
//         int zeroIndex = len;
//         int cur = 0;
//         for (int num : nums) {
//             if (num == 0) {
//                 --zeroIndex;
//             }
//             else {
//                 nums[cur] = num;
//                 ++cur;
//             }
//         }
        
//         while (zeroIndex < len) {
//             nums[zeroIndex] = 0;
//             ++zeroIndex;
//         }
//     }
// }
