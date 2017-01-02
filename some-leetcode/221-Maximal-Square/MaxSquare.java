// optimized version, combined loops
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxLength = 0;        
        for (int i = 1; i <= matrix.length; ++i) {
            for (int j = 1; j <= matrix[0].length; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        
        return maxLength * maxLength;
    }
}

/*public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int maxArea = 0;
		int[][] table = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; ++i) {
			if (matrix[i][0] == '1') {
				table[i][0] = 1;
				maxArea = 1;
			}
		}
		for (int i = 0; i < matrix[0].length; ++i) {
			if (matrix[0][i] == '1') {
				table[0][i] = 1;
				maxArea = 1;
			}
		}

		int minTemp;
		for (int i = 1; i < matrix.length; ++i) {
			for (int j = 1; j < matrix[0].length; ++j) {
				if (matrix[i][j] == '1') {
					minTemp = Math.min(table[i - 1][j], table[i][j - 1]);
					table[i][j] = Math.min(minTemp, table[i - 1][j - 1]) + 1;
					maxArea = Math.max(table[i][j], maxArea);
				}
				else {
					table[i][j] = 0;
				}
			}
		}

		return maxArea * maxArea;
    }
}
*/