
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        
        String temp = s.toLowerCase();
        
        int len = s.length();
        int[] nums = new int[len];
        int count = 0;
        
        for (int i = 0; i < len; ++i) {
            char cur = temp.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                nums[count] = cur - 'a' + 10;
                ++count;
            }
            else if (cur >= '0' && cur <= '9') {
                nums[count] = cur - '0';
                ++count;
            }
        }
        
        if (count == 0) {
            return true;
        }
        else {
            int left = 0, right = count - 1;
            while (left < right) {
                if (nums[left] != nums[right]) {
                    return false;
                }
                ++left;
                --right;
            }
            
            return true;
        }
    }
}
