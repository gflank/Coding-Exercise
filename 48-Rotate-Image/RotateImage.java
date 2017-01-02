
public class Solution {
    /*
    // not in place and too slow
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return;
        }
        
        int[][] result = new int[len][len];
        
        int x = len - 1, y = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                 result[y][x] = matrix[i][j];
                 ++y;
            }
            y = 0;
            --x;
        }
        
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                matrix[i][j] = result[i][j];
            }
        }
        
        return;
    }
    */
    
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len <= 1) {
            return;
        }
        
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
        for (int j = 1; j <= len / 2; ++j) {
            for (int i = 1; i <= len; ++i) {
                int temp = matrix[i - 1][j - 1];
                matrix[i - 1][j - 1] = matrix[i - 1][len - j];
                matrix[i - 1][len - j] = temp;
            }
            
        }
    }
}
