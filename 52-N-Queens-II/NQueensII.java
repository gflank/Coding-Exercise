// N-Queens II Total Accepted: 27483 Total Submissions: 76852 My Submissions Question Solution 
// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.



// Hide Tags Backtracking

import java.util.*;

public class NQueensII {
	private int total = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
        	return 0;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        queenHelper(n, path);

        return total;

    }

    private void queenHelper(int n, ArrayList<Integer> path) {
    	if (path.size() == n) {
    		++total;
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