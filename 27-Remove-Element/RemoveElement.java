
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        
        int curLen = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == val) {
                continue;
            }
            else {
                nums[curLen] = nums[i];
            }
            ++curLen;
        }
        
        return curLen;
    }
}
