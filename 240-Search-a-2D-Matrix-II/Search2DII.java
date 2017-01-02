public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xLen = matrix.length;
        if (xLen == 0) {
            return false;
        }
        int yLen = matrix[0].length;
        int x = 0, y = yLen - 1;
        
        while (x < xLen && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] < target) {
                ++x;
            }
            else {
                --y;
            }
        }
        
        return false;
    }
}