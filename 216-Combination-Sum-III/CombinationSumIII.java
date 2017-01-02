// Combination Sum III Total Accepted: 3906 Total Submissions: 14298 My Submissions Question Solution 
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

// Ensure that numbers within the set are sorted in ascending order.


// Example 1:

// Input: k = 3, n = 7

// Output:

// [[1,2,4]]

// Example 2:

// Input: k = 3, n = 9

// Output:

// [[1,2,6], [1,3,5], [2,3,4]]
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

// Hide Tags Array Backtracking

import java.util.*;

public class CombinationSumIII {
    private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0) {
        	return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        comHelper(k, n, path, 1);

        return result;
    }

    private void comHelper(int num, int target, ArrayList<Integer> path, int index) {
    	if (path.size() == num) {
	    	int pathSum = 0;
	    	for (int i = 0; i < path.size(); ++i) {
	    		pathSum += path.get(i);
	    	}
	    	if (pathSum == target) {
	    		result.add(new ArrayList<Integer>(path));
	    	}
	    	return;
    	}

    	for (int i = index; i <= 9; ++i) {
    		path.add(i);
    		comHelper(num, target, path, i + 1);
    		path.remove(path.size() - 1);
    	}
    }
}