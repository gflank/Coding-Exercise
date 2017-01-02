public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        
        for (int i = 0; i < gas.length; ++i) {
            sum = sum + gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        
        if (sum  < 0) {
            return -1;
        }
        else {
            if (minIndex != gas.length - 1) {
                return minIndex + 1;
            }
            else {
                return 0;
            }
        }
    }
}