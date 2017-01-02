public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        
        int max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            }
            // if from middle to current position add up to k
            else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            
            // if new sum, add to hashmap
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return max;
    }
}

// wrong answer
// public class Solution {
//     public int maxSubArrayLen(int[] nums, int k) {
//         if (nums.length == 0) {
//             return 0;
//         }
        
//         int sum = 0, maxCount = 0;
//         Queue<Integer> window = new LinkedList<Integer>();
        
//         for (int i = 0; i < nums.length; ++i) {
//             sum += nums[i];
//             // if sum is larger than target, pop the head out
//             while (sum > k) {
//                 int evicted = window.pop();
//                 sum -= evicted;
//             }
//             if (window.size() > maxCount) {
//                 maxCount = windows.size();
//             }
//         }
//     }
// }