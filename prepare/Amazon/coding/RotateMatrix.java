import java.util.*;

public class RotateMatrix {
	public static int[][] rotate(int[][] matrix, boolean clockwise) {
		int row = matrix.length;
		if (row == 0) {
			return null;
		}
		int col = matrix[0].length;
		if (col == 0) {
			return null;
		}

		int[][] res = new int[col][row];

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (clockwise) {
					res[j][row - 1 - i] = matrix[i][j];				
				}
				else {
					res[col - 1 - j][i] = matrix[i][j];
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// int[][] matrix = new int[2][3];
		// matrix[0] = new int[] {1, 2, 3};
		// matrix[1] = new int[] {4, 5, 6};
		int[][] matrix = new int[3][3];
		matrix[0] = new int[] {1, 2, 3};
		matrix[1] = new int[] {4, 5, 6};
		matrix[2] = new int[] {7, 8, 9};
		int[][] res = RotateMatrix.rotate(matrix, true);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.printf("%d ", res[i][j]);
			}
			System.out.println("");
		}
	}
}