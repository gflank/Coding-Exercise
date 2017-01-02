// Gray Code Total Accepted: 34700 Total Submissions: 105887 My Submissions Question Solution 
// The gray code is a binary numeral system where two successive values differ in only one bit.

// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
// Note:
// For a given n, a gray code sequence is not uniquely defined.

// For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

// For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

// Hide Tags Backtracking

import java.util.*;

public class GrayCode {
	// private ArrayList<Integer> result = new ArrayList<Integer>();
	// private int found = 0;

 //    public List<Integer> grayCode(int n) {
 //        if (n < 0) {
 //        	return result;
 //        }

 //        if (n == 0) {
 //        	result.add(0);
 //        	return result;
 //        }

 //        ArrayList<Integer> path = new ArrayList<Integer>();
 //        grayHelper(n, path);

 //        return result;
 //    }

 //    private void grayHelper(int num, ArrayList<Integer> path) {
 //    	if (found == 1) {
 //    		return;
 //    	}

 //    	if (path.size() == Math.pow(2, num)) {
 //    		result = new ArrayList<Integer>(path);
 //    		found = 1;
 //    		return;
 //    	}

 //    	int prev = Integer.MIN_VALUE;
 //    	for (int i = 0; i < Math.pow(2, num); ++i) {
 //    		if (prev != Integer.MIN_VALUE && path.contains(i) && i != prev + 1 && i != prev - 1 && ((i - prev) % 2 != 0) ) {
 //    			continue;
 //    		}
 //    		path.add(i);
 //    		grayHelper(num, path);
 //    		path.remove(path.size() - 1);
 //    		prev = i;
 //    	}
 //    }

	// private ArrayList<Integer> result = new ArrayList<Integer>();

 //    public List<Integer> grayCode(int n) {
 //        if (n < 0) {
 //        	return result;
 //        }

 //        if (n == 0) {
 //        	result.add(0);
 //        	return result;
 //        }

 //        ArrayList<Integer> path = new ArrayList<Integer>();
 //        int prev = Integer.MIN_VALUE;
 //        int range = (int)Math.pow(2, n);
 //        while (true) {
 //        	if (path.size() == range) {
 //        		result = new ArrayList<Integer>(path);
 //        		break;
 //        	}

 //        	for (int i = 0; i < range; ++i) {
 //        		if (prev != Integer.MIN_VALUE && path.contains(i) && i != prev + 1 && i != prev - 1 && ((i - prev) % 2 != 0)) {
 //        			continue;
 //        		}
 //        		path.add(i);
 //        		prev = i;
 //        	}
 //        }

 //        return result;
 //    }


	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}

		result = grayCode(n - 1);
		int temp;
		for (int i = result.size() - 1; i >= 0; --i) {
			temp = result.get(i);
			temp += 1 << (n - 1);
			result.add(temp);
		}

		return result;
	}
}