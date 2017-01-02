// Excel Sheet Column Title Total Accepted: 28758 Total Submissions: 158848 My Submissions Question Solution 
// Given a positive integer, return its corresponding column title as appear in an Excel sheet.

// For example:

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
// Credits:
// Special thanks to @ifanchu for adding this problem and creating all test cases.

// Hide Tags Math

import java.util.*;

public class ExcelTitle {
    public String convertToTitle(int n) {
    	if (n <= 0) {
    		return "";
    	}

    	String result = "";
    	int temp;
    	char bit;
    	while (n > 0) {
    		temp = (n - 1) % 26;
    		bit = (char)(temp + 'A');
    		result = bit + result;
    		n = (n - 1) / 26;
    	}

    	return result;
    }

    public static void main(String[] args) {
    	ExcelTitle A = new ExcelTitle();
    	System.out.println(A.convertToTitle(28));
    }
}
