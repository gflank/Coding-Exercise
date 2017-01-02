public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        
        // sort the array first
        Arrays.sort(nums);
        
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length - 2; ++i) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int tmp = nums[i] + nums[head] + nums[tail];

                if (Math.abs(tmp - target) < Math.abs(res - target)) {
                    res = tmp;
                }
                
                if (tmp == target) {
                    return tmp;
                }
                else if (tmp > target) {
                    --tail;
                }
                else if (tmp < target) {
                    ++head;
                }
            }
        }
        
        return res;
    }
}