// Valid Sudoku Total Accepted: 38446 Total Submissions: 141506 My Submissions Question Solution 
// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

// Hide Tags Hash Table

import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0) {
        	return false;
        }
        if (board[0].length == 0) {
        	return false;
        }

        HashSet<Character> validSet = new HashSet<Character>();
        // valid each row
        for (int row = 0; row < board.length; ++row) {
        	for (int col = 0; col < board[0].length; ++col) {
        		if (!helper(board[row][col], validSet)) {
        			return false;
        		}
        		validSet.add(board[row][col]);
        	}
        	validSet.clear();
        }

        // valid each column
        for (int col = 0; col < board[0].length; ++col) {
        	for (int row = 0; row < board.length; ++row) {
        		if (!helper(board[row][col], validSet)) {
        			return false;
        		}
        		validSet.add(board[row][col]);
        	}
        	validSet.clear();
        }

        // valid each matrix
        for (int i = 0; i < board.length; i += 3) {
        	for (int j = 0; j < board[0].length; j += 3) {
	        	for (int row = i; row < i + 3; ++row) {
	        		for (int col = j; col < j + 3; ++col) {
	        			if (!helper(board[row][col], validSet)) {
	        				return false;
	        			}
	        			validSet.add(board[row][col]);
	        		}
	        	}
	        	validSet.clear();
        	}
        }

        return true;
    }

    private boolean helper(char unit, HashSet<Character> validSet) {
    	if (unit == '.') {
    		return true;
    	}
    	if (validSet.contains(unit)) {
    		return false;
    	}
    	return true;
    }
}
