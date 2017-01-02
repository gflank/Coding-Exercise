
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        else if (n == 1) {
            int[][] result = new int[1][1];
            result[0][0] = 1;
            return result;
        }
        
        int[][] result = new int[n][n];
        fillMatrix(result, 1, 0, n - 1, 0, n - 1);
        
        return result;
    }
    
    private void fillMatrix(int[][] matrix, int cur, int rowBegin, int rowEnd, int colBegin, int colEnd) {
        if (rowEnd < rowBegin || colEnd < colBegin) {
            return;
        }
        
        // if one row or one column, fill it directly
        if (rowBegin == rowEnd) {
            for (int i = colBegin; i <= colEnd; ++i) {
                matrix[rowBegin][i] = cur;
                ++cur;
            }
            return;
        }
        if (colBegin == colEnd) {
            for (int i = rowBegin; i <= rowEnd; ++i) {
                matrix[i][colBegin] = cur;
                ++cur;
            }
            return;
        }
        
        // fill the outermost slots
        // up
        for (int i = colBegin; i <= colEnd; ++i) {
            matrix[rowBegin][i] = cur;
            ++cur;
        }
        // right
        for (int i = rowBegin + 1; i <= rowEnd; ++i) {
            matrix[i][colEnd] = cur;
            ++cur;
        }
        // bottom
        for (int i = colEnd - 1; i >= colBegin; --i) {
            matrix[rowEnd][i] = cur;
            ++cur;
        }
        // left
        for (int i = rowEnd - 1; i > rowBegin; --i) {
            matrix[i][colBegin] = cur;
            ++cur;
        }
        
        // call fillMatrix recursively
        fillMatrix(matrix, cur, rowBegin + 1, rowEnd - 1, colBegin + 1, colEnd - 1);
    }
}
