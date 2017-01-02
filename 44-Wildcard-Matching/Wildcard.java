// Wildcard Matching Total Accepted: 31429 Total Submissions: 210172 My Submissions Question Solution 
// Implement wildcard pattern matching with support for '?' and '*'.

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") -> false
// isMatch("aa","aa") -> true
// isMatch("aaa","aa") -> false
// isMatch("aa", "*") -> true
// isMatch("aa", "a*") -> true
// isMatch("ab", "?*") -> true
// isMatch("aab", "c*a*b") -> false
// Hide Tags Dynamic Programming Backtracking Greedy String

public class Wildcard {
    public boolean isMatch(String s, String p) {
    	if (s.length() == 0 && p.length() == 0) {
    		return true;
    	}
    	if (s.length() != 0 && p.length() == 0) {
    		return false;
    	}

    	int sPos = 0;
    	int pPos = 0;
    	int sMark = -1;
    	int pMark = -1;
    	while (sPos < s.length()) {
    		if (pPos < p.length() && (p.charAt(pPos) == '?' || p.charAt(pPos) == s.charAt(sPos))) {
    			++sPos;
    			++pPos;
    		}
    		else if (pPos < p.length() && p.charAt(pPos) == '*') {
    			sMark = sPos;
    			pMark = pPos;
    			++pPos;
    		}
    		else if (pMark != -1) {
    			pPos = pMark;
    			++sMark;
    			sPos = sMark;
    		}
    		else {
    			return false;
    		}
    	}
    	while (pPos < p.length() && p.charAt(pPos) == '*') {
    		++pPos;
    	}

    	return pPos == p.length();
    }
}
