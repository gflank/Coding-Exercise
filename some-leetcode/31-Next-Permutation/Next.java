// O(n) solution
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                // get the minimum number from behind that is larger than current number
                int minLarger = nums.length - 1;
                while (nums[i] >= nums[minLarger]) {
                    --minLarger;
                }
                // now swaping and break
                swapNums(i, minLarger, nums);
                reverseNums(i + 1, nums.length - 1, nums);
                break;
            }
            --i;
        }
        if (i < 0) {
            // no swap occur, reverse the array
            reverseNums(0, nums.length - 1, nums);
        }
    }
    
    private void swapNums(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    private void reverseNums(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}

// wrong answer
// public class Solution {
//     public void nextPermutation(int[] nums) {
//         if (nums.length <= 1) {
//             return;
//         }
        
//         int i = nums.length - 2;
//         while (i >= 0) {
//             if (nums[i] < nums[i + 1]) {
//                 // now swap this two and break
//                 int temp = nums[i];
//                 nums[i] = nums[i + 1];
//                 nums[i + 1] = temp;
//                 break;
//             }
//             --i;
//         }
//         if (i < 0) {
//             // no swap occur, reverse the array
//             int start = 0, end = nums.length - 1;
//             while (start < end) {
//                 int temp = nums[start];
//                 nums[start] = nums[end];
//                 nums[end] = temp;
//                 ++start;
//                 --end;
//             }
//         }
//     }
// }