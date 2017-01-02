// Combination Sum II Total Accepted: 36875 Total Submissions: 146514 My Submissions Question Solution 
// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 
// Hide Tags Array Backtracking

import java.util.*;

public class CombinationSumII {
	private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
        	return result;
        }

        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<Integer>();
        comHelper(candidates, target, path, 0);

        return result;
    }

    private void comHelper(int[] candidates, int target, ArrayList<Integer> path, int index) {
    	int pathSum = 0;
    	for (int i = 0; i < path.size(); ++i) {
    		pathSum += path.get(i);
    	}
    	if (pathSum == target) {
    		result.add(new ArrayList<Integer>(path));
    	}
    	else if (pathSum > target) {
    		return;
    	}

    	int prev = Integer.MIN_VALUE;
    	for (int i = index; i < candidates.length; ++i) {
    		if (prev != Integer.MIN_VALUE && candidates[i] == prev) {
    			continue;
    		}

    		path.add(candidates[i]);
    		comHelper(candidates, target, path, i + 1);
    		path.remove(path.size() - 1);
    		prev = candidates[i];
    	}
    }
}