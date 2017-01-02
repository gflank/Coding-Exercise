
public class Solution {
    /*
    // hashmap version
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        
        int half = len / 2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < len; ++i) {
            int cur = nums[i];
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            }
            else {
                int count = map.get(cur) + 1;
                if (count > half) {
                    return cur;
                }
                map.put(cur, count);
            }
        }
        
        return -1;
    }
    */
    
    // Majority Vote Algorithm, O(1) space
    public int majorityElement(int[] nums) {
        int count = 1, major = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                ++count;
                major = nums[i];
            }
            else {
                if (major == nums[i]) {
                    ++count;
                }
                else {
                    --count;
                }    
            }
        }
        
        return major;
    }
}
