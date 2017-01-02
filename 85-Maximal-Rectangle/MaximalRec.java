// rewrote with comments
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // store how many 1s occurred on the left (include itself)
        int[][] table = new int[matrix.length][matrix[0].length];
        // initialize the first col
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == '1') {
                table[i][0] = 1;
            }
        }
        // loop through the matrix to update the table
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '1') {
                    table[i][j] = table[i][j - 1] + 1;
                }
            }
        }
        // loop through the table to gain the max rectangle
        int maxArea = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                maxArea = Math.max(maxArea, localMax(i, j, table));
            }
        }

        return maxArea;
    }

    private int localMax(int row, int col, int[][] table) {
        if (table[row][col] == 0) {
            return 0;
        }
        int height = 1, width = table[row][col];
        
        // loop to the top
        for (int i = row - 1; i >= 0; --i) {
            if (table[i][col] < table[row][col]) {
                break;
            }
            ++height;
        }
        // loop to the bottom
        for (int i = row + 1; i < table.length; ++i) {
            if (table[i][col] < table[row][col]) {
                break;
            }
            ++height;
        }
        
        return height * width;
    }
}

// time O(m2n) + O(mn)

// public class MaximalRec {
//     public int maximalRectangle(char[][] matrix) {
//         if (matrix.length == 0 || matrix[0].length == 0) {
//         	return 0;
//         }

//  		int maxArea = 0;
//         // store how many 1s occurred on the left (include itself)
//         int[][] table = new int[matrix.length][matrix[0].length];
//         for (int i = 0; i < matrix.length; ++i) {
//         	if (matrix[i][0] == '1') {
//         		table[i][0] = 1;
//         	}
//         }
//         for (int i = 0; i < matrix.length; ++i) {
//         	for (int j = 1; j < matrix[0].length; ++j) {
//         		if (matrix[i][j] == '1') {
//         			table[i][j] = table[i][j - 1] + 1;
//         		}
//         	}
//         }

//  		for (int i = 0; i < matrix.length; ++i) {
//  			for (int j = 0; j < matrix[0].length; ++j) {
//  				maxArea = Math.max(maxArea, localMax(i, j, table));
//  			}
//  		}

//  		return maxArea;
//     }

//     private int localMax(int rowPos, int colPos, int[][] table) {
//     	if (table[rowPos][colPos] == 0) {
//     		return 0;
//     	}
//     	int height = 1;
//     	int width = table[rowPos][colPos];

//     	for (int i = rowPos - 1; i >= 0; --i) {
//     		if (table[i][colPos] < width) {
//     			break;
//     		}
//     		++height;
//     	}

//     	for (int i = rowPos + 1; i < table.length; ++i) {
//     		if (table[i][colPos] < width) {
//     			break;
//     		}
//     		++height;
//     	}

//     	return height * width;
//     }
// }
