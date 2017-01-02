// Word Break Total Accepted: 52253 Total Submissions: 227751 My Submissions Question Solution 
// Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

// Hide Tags Dynamic Programming

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.equals("") || s.length() == 0) {
        	return true;
        }

        int maxLength = 0;
        for (String word : wordDict) {
        	if (word.length() > maxLength) {
        		maxLength = word.length();
        	}
        }

        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
        	table[i] = false;
        	for (int j = 1; j <= i && j <= maxLength; ++j) {
        		if (!table[i - j]) {
        			continue;
        		}
        		String word = s.substring(i - j, i);
        		if (wordDict.contains(word)) {
        			table[i] = true;
        			break;
        		}
        	}
        }

        return table[s.length()];
    }
}