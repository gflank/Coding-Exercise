// Combinations Total Accepted: 43531 Total Submissions: 140852 My Submissions Question Solution 
// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
// Hide Tags Backtracking

import java.util.*;

public class Combinations {
	private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0) {
        	return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        comHelper(n, k, path, 1);

        return result;
    }

    private void comHelper(int range, int num, ArrayList<Integer> path, int index) {
    	if (path.size() == num) {
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}

    	for (int i = index; i <= range; ++i) {
    		path.add(i);
    		comHelper(range, num, path, i + 1);
    		path.remove(path.size() - 1);
    	}
    }
}