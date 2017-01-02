
import java.util.*;

// single number: only one number appears exactly one time, others more than one
public class Solution {
   public int single(int[] nums) {
       int len = nums.length;
       if (len == 0) {
           return 0;
       }
       
       Arrays.sort(nums);
       int pos = 1;
       int count = 1, prev = nums[0];
       while (pos < len - 1) {
           while (pos < len - 1 && nums[pos] == prev) {
               ++pos;
               ++count;
           }
           if (count == 1) {
               return prev;
           }
           count = 1;
           prev = nums[pos];
           ++pos;
       }
       
       return nums[len - 1];
    }

    public static void main(String[] argv) {
        Solution myTest = new Solution();
        int[] test = {2, 1, 1, 3, 2}; 
        System.out.println(myTest.single(test));
    }
}
