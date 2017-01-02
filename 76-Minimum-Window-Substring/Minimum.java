// Minimum Window Substring Total Accepted: 34245 Total Submissions: 181281 My Submissions Question Solution 
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the emtpy string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

// Hide Tags Hash Table Two Pointers String

import java.util.*;

public class Minimum {
    public String minWindow(String s, String t) {
        String result = "";
        // egde case
        if (s == null || t == null) {
        	return result;
        }
        if (s.length() == 0 && t.length() == 0) {
        	return result;
        }
        if (s.length() < t.length()) {
        	return result;
        }
        if (s.equals("") && t.equals("")) {
        	return result;
        }

        HashMap<Character, Integer> toFound = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); ++i) {
        	if (!toFound.containsKey(t.charAt(i))) {
        		toFound.put(t.charAt(i), 1);
        	}
        	else {
        		toFound.put(t.charAt(i), toFound.get(t.charAt(i)) + 1);
        	}
        }
        int sLeft = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        for (int sRight = 0; sRight < s.length(); ++sRight) {
        	// every time we visit a new character, put it into the found map
        	if (!found.containsKey(s.charAt(sRight))) {
	        	found.put(s.charAt(sRight), 1);
        	}
        	else {
        		found.put(s.charAt(sRight), found.get(s.charAt(sRight)) + 1);
        	}
        	// if it is what we need, increase the count
        	if (toFound.containsKey(s.charAt(sRight))) {
        		if (found.get(s.charAt(sRight)) <= toFound.get(s.charAt(sRight))) {
	        		++count;
        		}
        	}
        	// check whether the left side is needed, if not, pop it and modified the count and left pointer
        	while (sLeft < sRight && (!toFound.containsKey(s.charAt(sLeft)) || found.get(s.charAt(sLeft)) > toFound.get(s.charAt(sLeft)))) {
        		found.put(s.charAt(sLeft), found.get(s.charAt(sLeft)) - 1);
        		++sLeft;
        	}
        	// check if we have already got what we need
        	if (count == t.length()) {
        		if (sRight - sLeft < min) {
        			min = sRight - sLeft;
        			result = s.substring(sLeft, sRight + 1);
        		}
        	}
        }

        return result;
    }

    public static void main(String[] args) {
    	Minimum A = new Minimum();
    	String s = "ADOBECODEBANC";
    	String t = "ABC";
    	// String s = "aa";
    	// String t = "aa";
    	System.out.println(A.minWindow(s, t));
    }
}
