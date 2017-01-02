public class RangeSum2DMutable {
    private int[][] colSum;
    private int[][] matrix;

    public RangeSum2DMutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        this.matrix = matrix;
        colSum = new int[matrix.length + 1][matrix[0].length];
        for (int col = 0; col < matrix[0].length; ++col) {
            for (int row = 0; row < matrix.length; ++row) {
                colSum[row + 1][col] = colSum[row][col] + matrix[row][col];
            }
        }
    }

    public void update(int row, int col, int val) {
        // update affected cells
        for (int i = row; i < matrix.length; ++i) {
            colSum[i + 1][col] = colSum[i + 1][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // sum up all needed colSum
        int sum = 0;
        for (int col = col1; col <= col2; ++col) {
            sum += colSum[row2 + 1][col] - colSum[row1][col];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        int[] input = {3, 0, 1, 4, 2, 5, 6, 3, 2, 1, 1, 2, 0, 1, 5, 4, 1, 0, 1, 7, 1, 0, 3, 0, 5};
        int pos = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[i][j] = input[pos++];
            }
        }
        RangeSum2DMutable test = new RangeSum2DMutable(matrix);
        System.out.println(test.sumRegion(2, 1, 4, 3));
        test.update(3, 2, 2);
        System.out.println(test.sumRegion(2, 1, 4, 3));
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);