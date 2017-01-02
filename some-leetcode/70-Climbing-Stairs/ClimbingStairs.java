// Climbing Stairs Total Accepted: 56339 Total Submissions: 164030 My Submissions Question Solution 
// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Hide Tags Dynamic Programming

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
        	return n;
        }

        // memorize table
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;

        for (int i = 2; i < n; ++i) {
        	steps[i] = steps[i - 2] + steps[i - 1];
        }

        return steps[n - 1];
    }
}