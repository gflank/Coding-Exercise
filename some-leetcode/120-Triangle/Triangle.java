// Triangle Total Accepted: 41326 Total Submissions: 151224 My Submissions Question Solution 
// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

// Hide Tags Array Dynamic Programming

import java.util.*;

public class Triangle {
	private int n = 0;
	private int[][] sumTable;
	private List<List<Integer>> nums;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle == null) {
        	return 0;
        }	

        nums = triangle;

        n = triangle.size();
        sumTable = new int[n][n];
        for (int i = 0; i < n; ++i) {
        	for (int j = 0; j < n; ++j) {
        		sumTable[i][j] = Integer.MAX_VALUE;
        	}
        }

        return helper(0, 0);
    }

    private int helper(int row, int col) {
    	if (row == n) {
    		return 0;
    	}

    	// System.out.println(row + " & " + col);
    	// System.out.println(nums.get(row).get(col));

    	if (sumTable[row][col] != Integer.MAX_VALUE) {
    		// System.out.println("here");
    		return sumTable[row][col];
    	}
		
		sumTable[row][col] = Math.min(helper(row + 1, col), helper(row + 1, col + 1)) + nums.get(row).get(col);
		// System.out.println(sumTable[row][col]);

		return sumTable[row][col];
    }

    public static void main(String[] ars) {
    	Triangle A = new Triangle();
    	ArrayList<List<Integer>> input = new ArrayList<List<Integer>>();
    	ArrayList<Integer> sub = new ArrayList<Integer>();
    	sub.add(1);
    	input.add(new ArrayList<Integer>(sub));
    	sub.remove(sub.size() - 1);
    	sub.add(2);
    	sub.add(3);
    	input.add(new ArrayList<Integer>(sub));
    	System.out.println(A.minimumTotal(input));
    }
}