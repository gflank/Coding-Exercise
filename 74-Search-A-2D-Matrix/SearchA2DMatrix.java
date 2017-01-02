// rewrote version
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        
        // binary search in row first
        int start = 0, end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            else if (matrix[mid][0] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        
        if (matrix[start][0] == target || matrix[end][0] == target) {
            return true;
        }
        int row;
        if (matrix[start][0] < target && matrix[end][0] < target) {
            row = end;
        }
        else {
            row = start;
        }
        
        // binary search in col
        start = 0;
        end = matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            else if (matrix[row][mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}

// public class SearchA2DMatrix {
    
//     public boolean searchMatrix(int[][] matrix, int target) {

//         if (matrix == null) {
//         	return false;
//         }

//         int startRow = 0;
//         int endRow = matrix.length - 1;
//         int midRow;

//         while (startRow + 1 < endRow) {
//         	midRow = startRow + (endRow - startRow) / 2;
//         	if (matrix[midRow][0] == target) {
//         		return true;
//         	}
//         	else if (matrix[midRow][0] > target) {
//         		endRow = midRow;
//         	}
//         	else if (matrix[midRow][0] < target) {
//         		startRow = midRow;
//         	}
//         }

//         int row;
//         if (matrix[startRow][0] == target) {
//         	return true;
//         }
//         if (matrix[endRow][0] == target) {
//         	return true;
//         }
//         if (matrix[startRow][0] > target) {
//         	return false;
//         }
//         if (matrix[endRow][0] < target) {
//         	row = endRow;
//         }
//         else {
//             row = startRow;
//         }

//         int start = 0;
//         int end = matrix[0].length - 1;
//         int mid;

//         while (start + 1 < end) {
//         	mid = start + (end - start) / 2;
//         	if (matrix[row][mid] == target) {
//         		return true;
//         	}
//         	else if (matrix[row][mid] > target) {
//         		end = mid;
//         	}
//         	else if (matrix[row][mid] < target) {
//         		start = mid;
//         	}
//         }

//         if (matrix[row][start] == target) {
//         	return true;
//         }
//         if (matrix[row][end] == target) {
//         	return true;
//         }

//         return false;

//     }

//     public static void main(String[] args) {
//     	SearchA2DMatrix A = new SearchA2DMatrix();
//     	int[][] B = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//     	System.out.println(A.searchMatrix(B, 16));
//     }
// }