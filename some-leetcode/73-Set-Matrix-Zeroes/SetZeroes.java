
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int row0 = 1, col0 = 1, rowLen = matrix.length, colLen = matrix[0].length;
        
        // loop the first row and column first
        for (int i = 0; i < rowLen; ++i) {
            if (matrix[i][0] == 0) {
                col0 = 0;
                break;
            }
        }
        for (int i = 0; i < colLen; ++i) {
            if (matrix[0][i] == 0) {
                row0 = 0;
                break;
            }
        }
        
        // now scan for other all position to detect 0
        for (int i = 1; i < rowLen; ++i) {
            for (int j = 1; j < colLen; ++j) {
                if (matrix[i][j] == 0) {
                    // set the first row and column to 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // now set the 0 according to the flag bits
        // should set inside first
        for (int i = 1; i < rowLen; ++i) {
            for (int j = 1; j < colLen; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // now set the outside
        if (row0 == 0) {
            for (int i = 0; i < colLen; ++i) {
                matrix[0][i] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < rowLen; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
