// Distinct Subsequences Total Accepted: 32821 Total Submissions: 125046 My Submissions Question Solution 
// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Here is an example:
// S = "rabbbit", T = "rabbit"

// Return 3.

// Hide Tags Dynamic Programming String

public class DistinctSub {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.equals("") || t.equals("")) {
        	return 0;
        }

        int[][] table = new int[s.length()][t.length()];
        if (s.charAt(0) == t.charAt(0)) {
        	table[0][0] = 1;
        }
        for (int i = 1; i < s.length(); ++i) {
        	table[i][0] = table[i - 1][0];
        	if (s.charAt(i) == t.charAt(0)) {
        		++table[i][0];
        	}
        }
        for (int tPos = 1; tPos < t.length(); ++tPos) {
	        for (int sPos = tPos; sPos < s.length(); ++sPos) {
	        	table[sPos][tPos] = table[sPos - 1][tPos];
	        	if (s.charAt(sPos) == t.charAt(tPos)) {
	        		table[sPos][tPos] += table[sPos - 1][tPos - 1];
	        	}
    		}
        }

        return table[s.length() - 1][t.length() - 1];
    }
}