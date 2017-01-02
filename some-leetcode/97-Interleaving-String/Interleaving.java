// Interleaving String Total Accepted: 32237 Total Submissions: 155379 My Submissions Question Solution 
// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

// Hide Tags Dynamic Programming String

public class Interleaving {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
    		return true;
    	}
    	if (s1.length() + s2.length() != s3.length()) {
    		return false;
    	}

    	boolean table[][] = new boolean[s1.length() + 1][s2.length() + 1];
    	table[0][0] = true;
    	for (int i = 1; i <= s1.length(); ++i) {
    		if (s1.charAt(i - 1) == s3.charAt(i - 1) && table[i - 1][0]) {
    			table[i][0] = true;
    		}
    	}
    	for (int i = 1; i <= s2.length(); ++i) {
    		if (s2.charAt(i - 1) == s3.charAt(i - 1) && table[0][i - 1]) {
    			table[0][i] = true;
    		}
    	}

    	for (int i = 1; i <= s1.length(); ++i) {
    		for (int j = 1; j <= s2.length(); ++j) {
    			if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && table[i - 1][j]) {
    				table[i][j] = true;
    			}
    			if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && table[i][j - 1]) {
    				table[i][j] = true;
    			}
    		}
    	}

    	return table[s1.length()][s2.length()];
    }
}
