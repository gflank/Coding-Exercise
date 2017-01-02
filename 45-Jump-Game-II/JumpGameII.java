
public class Solution {
    /*
    // TLE version using exclusive method
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        int len = nums.length;
        // dp array stores the minimum steps we need to reach this position
        int[] dp = new int[len];
        // fill the array with maximum value
        Arrays.fill(dp, Integer.MAX_VALUE);
        if (nums[0] > 0) {
            dp[0] = 0;
        }
        else {
            // unreachable
            return -1;
        }
        
        for (int i = 0; i < len; ++i) {
            if (dp[i] != Integer.MAX_VALUE) {
                // current position
                int cur = i;
                // current miminum steps
                int count = dp[i];
                while (cur < len - 1 && nums[cur] != 0) {
                    // increase the stop count first
                    ++count;
                    // calculate the positon the next step could reach
                    cur = cur + nums[cur];
                    // if the index exceed the range, fix it
                    if (cur > len - 1){
                        cur = len - 1;
                    }
                    // revise the bits if count is smaller
                    for (int j = i + 1; j <= cur; ++j) {
                        if (count < dp[j]) {
                            dp[j] = count;
                        }
                    }
                }
            }
        }
        
        return dp[len - 1];
    }
    */
    
    // greedy version
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        
        // max means the edge we could currently reach for last step and
        // nextMax means the edge we could currently reach for this step
        // count represents the steps we used
        int max = 0, nextMax = 0, count = 0;
        for (int i = 0; i < len - 1 && max < len - 1; ++i) {
            nextMax = Math.max(nextMax, nums[i] + i);
            // greedy algorithm, we increase the step only when we have to do so
            if (i == max) {
                max = nextMax;
                ++count;
            }
        }
        
        // if could not even reach the end
        if (max < len - 1) {
            return -1;
        }
        else {
            return count;
        }
    }
}
