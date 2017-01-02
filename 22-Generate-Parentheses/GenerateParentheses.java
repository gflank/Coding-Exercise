// Generate Parentheses Total Accepted: 47129 Total Submissions: 144656 My Submissions Question Solution 
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"

// Hide Tags Backtracking String

import java.util.*;

public class GenerateParentheses {
    private ArrayList<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
        	return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        generateHelper(n, path);

        return result;
    }

    private void generateHelper(int n, ArrayList<Integer> path) {
    	if (pathSum(path) < 0) {
    		return;
    	}
    	if (path.size() == n * 2 && pathSum(path) == 0) {
    		result.add(transfer(path));
    		return;
    	}
    	if (path.size() >= n * 2) {
    		return;
    	}

    	for (int i = 1; i >= -1; i = i - 2) {
    		path.add(i);
    		generateHelper(n, path);
    		path.remove(path.size() - 1);
    	}


    }

    private int pathSum(ArrayList<Integer> path) {
    	int sum = 0;
    	for (int i = 0; i < path.size(); ++i) {
    		sum += path.get(i);
    	}
    	return sum;
    }

    private String transfer(ArrayList<Integer> path) {
    	String parenthesis = "";
    	for (int i = 0; i < path.size(); ++i) {
    		if (path.get(i) == 1) {
    			parenthesis += "(";
    		}
    		else {
    			parenthesis += ")";
    		}
    	}
    	return parenthesis;
    }
}