public class Solution {
    private int[][] neis = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (dp[i][j] != 0) continue;
                int cur = dfs(matrix, dp, i, j, Integer.MIN_VALUE);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int[][] dp, int i, int j, int prev) {
        if (prev >= matrix[i][j]) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int curMax = 0;
        for (int[] nei : neis) {
            int nextI = i + nei[0];
            int nextJ = j + nei[1];
            if (nextI >= 0 && nextI < matrix.length && nextJ >= 0 && nextJ < matrix[0].length) {
                curMax = Math.max(curMax, dfs(matrix, dp, nextI, nextJ, matrix[i][j]));
            }
        }
        dp[i][j] = curMax + 1;
        return dp[i][j];
    }
}