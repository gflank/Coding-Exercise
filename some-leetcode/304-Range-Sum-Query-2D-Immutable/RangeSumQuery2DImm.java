// rewrote version
public class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; ++i) {
            for (int j = 1; j <= matrix[0].length; ++j) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}


// unneat version
public class NumMatrix {
    private int[][] dp;
    private boolean valid;

    public NumMatrix(int[][] matrix) {
        valid = true;
        if (matrix.length == 0 || matrix[0].length == 0) {
            valid = false;
            return;
        }
        
        dp = new int[matrix.length][matrix[0].length];
        int sum = 0;
        // update first col
        for (int i = 0; i < matrix.length; ++i) {
            sum += matrix[i][0];
            dp[i][0] = sum;
        }
        // update first row
        sum = 0;
        for (int i = 0; i < matrix[0].length; ++i) {
            sum += matrix[0][i];
            dp[0][i] = sum;
        }
        // update remaining
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                dp[i][j] = matrix[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (!valid) {
            return -1;
        }
        
        if (row1 == 0 && col1 == 0) return dp[row2][col2];
        else if (row1 == 0) return dp[row2][col2] - dp[row2][col1 - 1];
        else if (col1 == 0) return dp[row2][col2] - dp[row1 - 1][col2];
        return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);