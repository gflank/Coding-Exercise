public class Solution {
    // using queue is really slow
    // public int minSubArrayLen(int s, int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
        
    //     Queue<Integer> queue = new LinkedList<Integer>();
    //     int min = Integer.MAX_VALUE;
    //     int sum = 0;
    //     for (int i = 0; i < nums.length; ++i) {
    //         sum += nums[i];
    //         queue.offer(nums[i]);
    //         while (sum >= s) {
    //             sum -= queue.poll();
    //             if (sum < s) {
    //                 min = Math.min(min, queue.size() + 1);
    //             }
    //         }
    //     }
        
    //     if (min != Integer.MAX_VALUE) {
    //         return min;
    //     }
    //     else {
    //         return 0;
    //     }
    // }
    
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int head = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (sum >= s) {
                sum -= nums[head];
                ++head;
                if (sum < s) {
                    min = Math.min(min, i - head + 2);
                }
            }
        }
        
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        else {
            return 0;
        }
    }
}