// Anagrams Total Accepted: 39413 Total Submissions: 162066 My Submissions Question Solution 
// Given an array of strings, return all groups of strings that are anagrams.

// Note: All inputs will be in lower-case.

// Hide Tags Hash Table String

import java.util.*;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
        	return result;
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String temp;
        for (int i = 0; i < strs.length; ++i) {
        	temp = sortString(strs[i]);
    		if (!map.containsKey(temp)) {
    			map.put(temp, i);
    		}
    		else {
    			if (map.get(temp) != -1) {
    				result.add(strs[map.get(temp)]);
    				map.put(temp, -1);
    			}
    			result.add(strs[i]);
    		}
        }

        return result;
    }

    private String sortString(String str) {
    	char[] strArray = str.toCharArray();
    	Arrays.sort(strArray);
    	String sorted = new String(strArray);

    	return sorted;
    }
}
