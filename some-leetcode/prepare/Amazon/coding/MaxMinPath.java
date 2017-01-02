import java.util.*;

public class MaxMinPath {
	public int maxMinPath(int[][] matrix) {
		int row = matrix.length;
		if (row == 0) {
			return -1;
		}
		int col = matrix[0].length;
		if (col == 0) {
			return -1;
		}

		// initialize a n^2 dp table
		// indicating the max(min(all values in the pathes))
		int[][] dp = new int[row][col];
		dp[0][0] = matrix[0][0];
		for (int i = 1; i < col; ++i) {
			dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
		}
		for (int i = 1; i < row; ++i) {
			dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
		}

		// now loop through the remain positions
		for (int i = 1; i < row; ++i) {
			for (int j = 1; j < col; ++j) {
				int candidate1 = Math.min(matrix[i][j], dp[i - 1][j]);
				int candidate2 = Math.min(matrix[i][j], dp[i][j - 1]);
				dp[i][j] = Math.max(candidate1, candidate2);
			}
		}
		return dp[row - 1][col - 1];
	}

	public static void main(String[] args) {
		MaxMinPath test = new MaxMinPath();
		int[][] matrix = new int[2][3];
		matrix[0][0] = 8;
		matrix[0][1] = 4;
		matrix[0][2] = 7;
		matrix[1][0] = 6;
		matrix[1][1] = 5;
		matrix[1][2] = 9;
		System.out.println(test.maxMinPath(matrix));
	}
}