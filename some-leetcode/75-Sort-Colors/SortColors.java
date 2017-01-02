public class Solution {
    public void sortColors(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        for (int i = 0; i <= tail; ++i) {
            while (nums[i] == 2 && i <= tail) {
                int tmp = nums[i];
                nums[i] = nums[tail];
                nums[tail] = tmp;
                --tail;
            }
            while (nums[i] == 0 && i >= head) {
                int tmp = nums[i];
                nums[i] = nums[head];
                nums[head] = tmp;
                ++head;
            }
        }
    }
}

// wrong version
// public class Solution {
//     public void sortColors(int[] nums) {
//         if (nums.length <= 1) {
//             return;
//         }
        
//         int head = -1;
//         int tail = nums.length;
        
//         int i = 0;
//         while (i < tail) {
//             if (nums[i] == 0) {
//                 ++head;
//                 int tmp = nums[i];
//                 nums[i] = nums[head];
//                 nums[head] = tmp;
//                 if (i == head) {
//                     ++i;
//                 }
//             }
//             else if (nums[1] == 2) {
//                 --tail;
//                 int tmp = nums[i];
//                 nums[i] = nums[tail];
//                 nums[tail] = tmp;
//             }
//             else {
//                 ++i;
//             }
//         }
//     }
// }