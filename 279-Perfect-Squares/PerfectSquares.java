// neat version
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

// ArrayList version, but slower
public class Solution {
    public int numSquares(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0); // dp[0] = 0
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                min = Math.min(min, dp.get(i - j * j) + 1);
            }
            dp.add(min);
        }
        return dp.get(n);
    }
}

// wrong version
public class Solution {
    public int numSquares(int n) {
        return helper(n, 0);
    }
    
    private int closestSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt;
    }
    
    private int helper(int n, int count) {
        if (n == 0) {
            return count;
        }
        return helper(n - closestSquare(n), count + 1);
    }
}