
public class Solution {
    /*
    // with extra space version
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        
        int[] result = new int[len];
        int[] temp = new int[len];
        temp[0] = 1;
        result[len - 1] = 1;
        
        for (int i = 1, j = len - 2; i < len; ++i, --j) {
            temp[i] = temp[i - 1] * nums[i - 1];
            result[j] = result[j +1] * nums[j + 1];
        }
        
        for (int i = 0; i < len; ++i) {
            result[i] *= temp[i];
        }
        
        return result;
    }
    */
    
    // without extra space version
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        
        int[] result = new int[len];
        result[len - 1] = 1;
        
        for (int j = len - 2; j >= 0; --j) {
            result[j] = result[j +1] * nums[j + 1];
        }
        
        int curProduct = 1;
        for (int i = 1; i < len; ++i) {
            curProduct *= nums[i - 1];
            result[i] *= curProduct;
        }
        
        return result;
    }
}
