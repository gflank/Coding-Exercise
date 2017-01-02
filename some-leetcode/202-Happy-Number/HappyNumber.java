// Happy Number Total Accepted: 17129 Total Submissions: 54664 My Submissions Question Solution 
// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
// Credits:
// Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.

// Hide Tags Hash Table Math

import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
    	if (n == 0) {
    		return false;
    	}

    	int sum = 0;
    	int temp = n;
    	Set<Integer> hash = new HashSet<Integer>();

    	while (true) {
	    	while (temp != 0) {
	    		sum += Math.pow(temp % 10, 2);
	    		temp /= 10;
	    	}
			if (sum == 1) {
				return true;
			}
			else {
				if (hash.contains(sum)) {
					return false;
				}
				else {
					hash.add(sum);	
				}
			}
			temp = sum;
			sum = 0;
    	}
    }

    public static void main(String[] args) {
    	HappyNumber A = new HappyNumber();
    	int n = 2;
    	System.out.println(A.isHappy(n));
    }
}
