// Letter Combinations of a Phone Number Total Accepted: 41800 Total Submissions: 162059 My Submissions Question Solution 
// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.



// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.

// Hide Tags Backtracking String

import java.util.*;

public class PhoneNumber {
	private ArrayList<String> result = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
        	return result;
        }

        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});

        StringBuilder path = new StringBuilder();
        phoneHelper(digits, map, path);
        return result;
    }

    private void phoneHelper(String digits, Map<Character, char[]> map, StringBuilder path) {
    	if (path.length() == digits.length()) {
    		result.add(path.toString());
    		return;
    	}

    	for (char single : map.get(digits.charAt(path.length()))) {
    		path.append(single);
    		phoneHelper(digits, map, path);
    		path.deleteCharAt(path.length() - 1);
    	}
    }
}