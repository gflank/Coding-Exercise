// Excel Sheet Column Number Total Accepted: 32334 Total Submissions: 88484 My Submissions Question Solution 
// Related to question Excel Sheet Column Title

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Hide Tags Math

import java.util.*;

public class ExcelCol {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }

        int temp;
        int col = 0;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
        	temp = sChar[i] - 'A' + 1;
        	col += temp * Math.pow(26, s.length() - 1 - i);
        }

        return col;
    }

    public static void main(String[] args) {
    	ExcelCol A = new ExcelCol();
    	String s = "AB";
    	System.out.println(A.titleToNumber(s));
    }
}
