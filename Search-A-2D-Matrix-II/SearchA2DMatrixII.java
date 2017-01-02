// LintCode
// Medium Search a 2D Matrix II

// 26% Accepted
// Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

// This matrix has the following properties:

//     * Integers in each row are sorted from left to right.

//     * Integers in each column are sorted from up to bottom.

//     * No duplicate integers in each row or column.

// Example
// Consider the following matrix:

// [

//     [1, 3, 5, 7],

//     [2, 4, 7, 8],

//     [3, 5, 9, 10]

// ]

// Given target = 3, return 2.

// Challenge
// O(m+n) time and O(1) extra space

public class SearchA2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if (matrix == null || matrix.length == 0) {
    		return 0;
    	}

    	int count = 0;
    	int rowMax = matrix.length - 1;
    	int columnMax = matrix[0].length - 1;
    	int row = rowMax;
    	int column = 0;

    	while (true) {
    		if (row < 0 || column > columnMax) {
    			break;
    		}

    		if (matrix[row][column] == target) {
    			++count;
    			--row;
    			++column;
    		}
    		else if (matrix[row][column] > target) {
    			--row;
    		}
    		else {
    			++column;
    		}
    	}

    	return count;
    }

    public static void main(String[] args) {
    	SearchA2DMatrixII A = new SearchA2DMatrixII();
    	int[][] B = {{1, 3, 5, 7}, {2, 4, 7, 8}, {3, 5, 9, 10}};
    	// System.out.println(A.searchMatrix(B, 5));
    	int[][] C = new int[0][0];
    	System.out.println(A.searchMatrix(C, 5));
    }
}
