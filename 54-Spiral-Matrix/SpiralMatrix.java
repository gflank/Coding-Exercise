
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        addOutermost(res, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        
        return res;
    }
    
    // this function is use to add the outermost element to the res for each call
    // it will call itself recursively
    public void addOutermost(ArrayList<Integer> res, int[][] matrix, int rowBegin, int rowEnd, int colBegin, int colEnd) {
        if (rowEnd < rowBegin || colEnd < colBegin) {
            return;
        }
        
        // if only one row or one column left, add them directly
        if (rowEnd == rowBegin) {
            for (int i = colBegin; i <= colEnd; ++i) {
                res.add(matrix[rowBegin][i]);
            }
            return;
        }
        if (colEnd == colBegin) {
            for (int i = rowBegin; i <= rowEnd; ++i) {
                res.add(matrix[i][colBegin]);
            }
            return;
        }
        
        // otherwise, walk through the outermost elements
        // the above one
        for (int i = colBegin; i <= colEnd; ++i) {
            res.add(matrix[rowBegin][i]);
        }
        // the right one
        for (int i = rowBegin + 1; i <= rowEnd; ++i) {
            res.add(matrix[i][colEnd]);
        }
        // the bottom one
        for (int i = colEnd - 1; i >= colBegin; --i) {
            res.add(matrix[rowEnd][i]);
        }
        // the left one
        for (int i = rowEnd - 1; i > rowBegin; --i) {
            res.add(matrix[i][colBegin]);
        }
        
        // recursively call
        addOutermost(res, matrix, rowBegin + 1, rowEnd - 1, colBegin + 1, colEnd - 1);
    }
}
