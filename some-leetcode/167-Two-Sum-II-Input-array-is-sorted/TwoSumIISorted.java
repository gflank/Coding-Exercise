
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[2];
        
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if ( sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            else if (sum > target) {
                --right;
            }
            else {
                ++left;
            }
        }
        
        return new int[0];
    }
}
