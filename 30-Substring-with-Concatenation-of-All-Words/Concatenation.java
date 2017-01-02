// Substring with Concatenation of All Words Total Accepted: 32642 Total Submissions: 167821 My Submissions Question Solution 
// You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]

// You should return the indices: [0,9].
// (order does not matter).

// Hide Tags Hash Table Two Pointers String

import java.util.*;

public class Concatenation {
    public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// edge case
		if (s == null || s.equals("") || words == null || words.length == 0) {
			return result;
		}

		// set up the words table
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		for (String word : words) {
			if (!toFind.containsKey(word)) {
				toFind.put(word, 1);
			}
			else {
				toFind.put(word, toFind.get(word) + 1);
			}
		}

		// get the word length and words number
		int length = words[0].length();
		int number = words.length;
		int count = 0;
		String temp;

		// set up the found map
		HashMap<String, Integer> found = new HashMap<String, Integer>();

		// loop over the String s
		for (int i = 0; i <= s.length() - length * number; ++i) {
			for (int j = i ; j < i + number * length; j += length) {
				// key point!
				temp = s.substring(j, j + length);
				// make sure this word is what we need
				if (!toFind.containsKey(temp)) {
					break;
				}
				// put the word into found map
				if (!found.containsKey(temp)) {
					found.put(temp, 1);
				}
				else {
					found.put(temp, found.get(temp) + 1);
				}
				// increase counter
				++count;
				// check if we already have too many words
				if (found.get(temp) > toFind.get(temp)) {
					break;
				}
				// if we've got all we need, add result
				if (count == number) {
					result.add(i);
					break;
				}
			}
			// clear the map every sub loop
			found.clear();
			count = 0;
		}

		return result;
    }

    public static void main(String[] args) {
    	Concatenation A = new Concatenation();
    	// String s = "barfoothefoobarman";
    	// String[] words = {"foo", "bar"};
    	String s = "a";
    	String[] words = {"a"};
    	List<Integer> result = A.findSubstring(s, words);
    	for (Integer i : result) {
    		System.out.println(i);
    	}
    }
}
