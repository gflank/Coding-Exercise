// Hard Coins in a Line III

// 30% Accepted
// There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.

// Could you please decide the first player will win or lose?

// Have you met this question in a real interview? Yes
// Example
// Given array A = [3,2,2], return true.

// Given array A = [1,2,4], return true.

// Given array A = [1,20,4], return false.

// Challenge
// Follow Up Question:

// If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?

// Tags Expand 
// Dynamic Programming Array Game Theory

public class Coins3 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length <= 1) {
        	return true;
        }
        if (values.length == 2) {
        	if (values[0] == values[1]) {
        		return false;
        	}
        	return true;
        }

        int n = values.length;

        // represent if start from this range [i, j], the max values could gain
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < dp.length; ++i) {
        	for (int j = 1; j < dp[0].length; ++j) {
        		dp[i][j] = Integer.MAX_VALUE;
        	}
        }

        // the initial status, when i == j, only one choice
        for (int i = 1; i <= n; ++i) {
        	dp[i][i] = values[i - 1];
        }

        // i means the start of range, j means the end, inclusive
        // loop from i == j, left to right, bottom to top (in DP table view)
        int sum = 0;
        for (int i = n; i >= 1; --i) {
        	sum += values[i - 1];
            for (int j = i + 1; j <= n; ++j) {
                // two conditions
                // 1: take the first coin -> number i
                // then enemy start from position: (i + 1, j)
                // my next start position: (i + 2, j) or (i + 1, j - 1)
                int solution1 = values[i - 1] + ableToGain(dp, i + 1, j);
                // 2: take the last coin -> number j
                // then enemy start from position: (i, j - 1)
                // my next start position: (i + 1, j - 1) or (i, j - 2)
                int solution2 = values[j - 1] + ableToGain(dp, i, j - 1);
                dp[i][j] = Math.max(solution1, solution2);
            }
        }

        // System.out.println(dp[1][n]);
        return dp[1][n] > sum - dp[1][n];
    }

    private int ableToGain(int[][] dp, int start, int end) {
        // (start, end) is the starting position for the enemy
        if (start == end) return 0;
        // return two possible solution for my next step
        return Math.min(dp[start + 1][end], dp[start][end - 1]);
    }

    public static void main(String args[]) {
        Coins3 A = new Coins3();
    	int[] values = {1, 4};
    	System.out.println(A.firstWillWin(values));
        System.out.println(A.firstWillWinII(values));
        System.out.println("");

        int[] values2 = {3, 2, 2};
        System.out.println(A.firstWillWin(values2));
        System.out.println(A.firstWillWinII(values2));
        System.out.println("");

        int[] values3 = {1, 2, 4};
        System.out.println(A.firstWillWin(values3));
        System.out.println(A.firstWillWinII(values3));
        System.out.println("");

        int[] values4 = {1, 20, 4};
        System.out.println(A.firstWillWin(values4));
        System.out.println(A.firstWillWinII(values4));
        System.out.println("");

        int[] values5 = {1, 2, 7, 8, 5, 9, 3, 2, 4, 1, 4};
        System.out.println(A.firstWillWin(values5));
        System.out.println(A.firstWillWinII(values5));
        System.out.println("");
    }

    // back tracking version
    public boolean firstWillWinII(int[] values) {
        return winOrNot(values, 0, values.length - 1, 0, 0);
    }

    public boolean winOrNot(int[] values, int start, int end, int enemyGain, int prevGain) {
        // end condition
        if (start == end) {
            return prevGain + values[start] > enemyGain;
        }

        // now try two different solutions
        // if enemy return false, we win
        if (!winOrNot(values, start + 1, end, prevGain + values[start], enemyGain) || !winOrNot(values, start, end - 1, prevGain + values[end], enemyGain)) return true;
        // otherwise, we lose
        return false;
    }
}
