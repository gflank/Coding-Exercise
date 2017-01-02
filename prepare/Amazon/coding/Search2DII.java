import java.util.*;

public class Search2DII {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if (row == 0) {
			return false;
		}
		int col = matrix[0].length;
		if (col == 0) {
			return false;
		}

		// scan from the right-top corner, time complexity O(N)
		int posCol = col - 1, posRow = 0;
		while (posCol >= 0 && posRow < row) {
			if (matrix[posRow][posCol] == target) {
				return true;
			}
			else if (matrix[posRow][posCol] > target) {
				--posCol;
			}
			else {
				++posRow;
			}
		}
		// found nothing
		return false;
	}
}
