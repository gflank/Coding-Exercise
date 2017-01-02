// N-Queens Total Accepted: 31971 Total Submissions: 120210 My Submissions Question Solution 
// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
// Hide Tags Backtracking

import java.util.*;

public class NQueens {
	private ArrayList<String[]> result = new ArrayList<String[]>();

    public List<String[]> solveNQueens(int n) {
        if (n <= 0) {
        	return new ArrayList<String[]>();
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        queenHelper(n, path);

        return result;

    }

    private void queenHelper(int n, ArrayList<Integer> path) {
    	if (path.size() == n) {
    		result.add(generateChess(path));
    		return;
    	}

    	for (int i = 0; i < n; ++i) {
    		if (!isValid(path, i)) {
    			continue;
    		}
    		path.add(i);
    		queenHelper(n, path);
    		path.remove(path.size() - 1);
    	}
    }

    private String[] generateChess(ArrayList<Integer> path) {
    	String[] pathString = new String[path.size()];
    	for (int i = 0; i < path.size(); ++i) {
    		pathString[i] = "";
    		for (int j = 0; j < path.size(); ++j) {
    			if (j == path.get(i)) {
    				pathString[i] += "Q";
    			}
    			else {
    				pathString[i] += ".";
    			}
    		}
    	}

    	return pathString;
    }

    private Boolean isValid(ArrayList<Integer> path, int columnCurrent) {
    	if (path.contains(columnCurrent)) {
    		return false;
    	}

    	for (int row = 0; row < path.size(); ++row) {
	    	// top-left to bottom-right, row - column
    		if ((row - path.get(row)) == (path.size() - columnCurrent)) {
    			return false;
    		}

    		// top-right to bottom-left, row + column
    		if ((row + path.get(row)) == (path.size() + columnCurrent)) {
    			return false;
    		}
    	}

    	return true;
    }
}