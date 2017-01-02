// Medium Coins in a Line II

// 29% Accepted
// There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.

// Could you please decide the first player will win or lose?

// Have you met this question in a real interview? Yes
// Example
// Given values array A = [1,2,2], return true.

// Given A = [1,2,4], return false.

// Tags Expand 
// Dynamic Programming Array Game Theory

public class Coins2 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length == 0) return false;
        if (values.length <= 2) return true;
        
        int[] dp = new int[values.length + 1];
        dp[values.length] = 0;
        dp[values.length - 1] = values[values.length - 1];
        dp[values.length - 2] = values[values.length - 1] + values[values.length - 2];
        dp[values.length - 3] = values[values.length - 2] + values[values.length - 3];
        
        int sum = values[values.length - 1] + values[values.length - 2] + values[values.length - 3];
        for (int i = values.length - 4; i >= 0; --i) {
            sum += values[i];

            int solution1 = values[i] + Math.min(dp[i + 2], dp[i + 3]);
            int solution2 = values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]);
            dp[i] = Math.max(solution1, solution2);
        }
        return dp[0] > sum - dp[0];
    }
}
