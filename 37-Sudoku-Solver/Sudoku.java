// Sudoku Solver Total Accepted: 29363 Total Submissions: 134783 My Submissions Question Solution 
// Write a program to solve a Sudoku puzzle by filling the empty cells.

// Empty cells are indicated by the character '.'.

// You may assume that there will be only one unique solution.


// A sudoku puzzle...


// ...and its solution numbers marked in red.

// Hide Tags Backtracking Hash Table

public class Sudoku {
    public void solveSudoku(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
        	return;
        }

        helper(board);
    }

    private boolean helper(char[][] board) {
    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[0].length; ++j) {
    			if (board[i][j] == '.') {
    				for (char num = '1'; num <= '9'; ++num) {
    					if (isValid(board, i, j, num)) {
	    					board[i][j] = num;
	    					if (helper(board)) {
	    						return true;
	    					}
	    					else {
	    						board[i][j] = '.';
	    					}
    					}
    				}
			    	// if no proper solution
    				return false;
    			}
    		}
    	}

    	return true;
    }

    private boolean isValid(char[][] board, int rowPos, int colPos, char num) {
    	// check column
    	for (int i = 0; i < board.length; ++i) {
    		if (board[i][colPos] == num) {
    			return false;
    		}
    	}

    	// check row
    	for (int i = 0; i < board[0].length; ++i) {
    		if (board[rowPos][i] == num) {
    			return false;
    		}
    	}

    	// check sudoku
    	int rowStart = rowPos / 3 * 3;
    	int colStart = colPos / 3 * 3;
    	for (int i  = rowStart; i < rowStart + 3; ++i) {
    		for (int j = colStart; j < colStart + 3; ++j) {
    			if (board[i][j] == num) {
    				return false;
    			}
    		}
    	}

    	return true;
    }
}