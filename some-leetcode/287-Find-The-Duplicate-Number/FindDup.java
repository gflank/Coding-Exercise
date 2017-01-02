public class Solution {
    public int findDuplicate(int[] nums) {
        // adopted the method derived from finding cycle in linkedlist
        int slow = nums.length, fast = nums.length;
        while (true) {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
            if (slow == fast) {
                break;
            }
        }
        
        fast = nums.length;
        while (true) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
            if (slow == fast) {
                break;
            }
        }
        
        return slow;
    }
}