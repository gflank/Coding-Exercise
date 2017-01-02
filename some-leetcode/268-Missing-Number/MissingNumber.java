
public class Solution {
    // deduct from sum version
    /*
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        
        return sum;
    }
    */
    
    // XOR version
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int result = 0 ^ nums[0];
        for (int i = 1; i < len; ++i) {
            result ^= i ^ nums[i];
        }
        result ^= len;
        
        return result;
    }
}
