// Palindrome Partitioning Total Accepted: 40947 Total Submissions: 153510 My Submissions Question Solution 
// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]
// Hide Tags Backtracking

import java.util.*;

public class Palindrome {
	private ArrayList<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        if (s.equals("") || s.length() == 0) {
        	return result;
        }

        ArrayList<String> path = new ArrayList<String>();
        helper(s, 0, path);

        return result;
    }

    private void helper(String s, int pos, ArrayList<String> path) {
    	if (pos == s.length()) {
    		result.add(new ArrayList<String>(path));
    		return;
    	}

    	for (int i = pos; i < s.length(); ++i) {
    		String sub = s.substring(pos, i + 1);
    		if (!judge(sub)) {
    			continue;
    		}
    		path.add(sub);
    		helper(s, i + 1, path);
    		path.remove(path.size() - 1);
    	}
    }

    private boolean judge(String s) {
    	for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
    		if (s.charAt(i) != s.charAt(j)) {
    			return false;
    		}
    	}
    	return true;
    }
}
