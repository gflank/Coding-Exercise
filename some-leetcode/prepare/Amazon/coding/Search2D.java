import java.util.*;

public class Search2D {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if (row == 0) {
			return false;
		}
		int col = matrix[0].length;
		if (col == 0) {
			return false;
		}

		// search for row first
		int start = 0, end = row - 1;
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
		// at last we get two possible row numbers stored in start and end
		// now check which row to go with
		int rowNum;
		if (matrix[start][0] > target) {
			return false;
		}
		else if (matrix[start][0] == target || matrix[end][0] == target) {
			return true;
		}
		else if (matrix[end][0] < target) {
			rowNum = end;
		}
		else {
			rowNum = start;
		}

		// now search in a row
		start = 0;
		end = col - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (matrix[rowNum][mid] == target) {
				return true;
			}
			else if (matrix[rowNum][mid] > target) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		// at last we also get two possible number, check them both
		if (matrix [rowNum][start] == target || matrix[rowNum][end] == target) {
			return true;
		}
		// found nothing
		return false;
	}

	public static void main(String[] args) {
		Search2D test = new Search2D();
		int[][] matrix = new int[2][1];
		matrix[0][0] = 1;
		matrix[1][0] = 3;
		System.out.println(test.searchMatrix(matrix, 0));
	}
}
