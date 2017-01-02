// Unique Binary Search Trees Total Accepted: 50465 Total Submissions: 139810 My Submissions Question Solution 
// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

// For example,
// Given n = 3, there are a total of 5 unique BST's.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
// Hide Tags Tree Dynamic Programming

public class Solution {
    public int numTrees(int n) {
    	int[] history = new int[n + 1];
        history[0] = 1;
        history[1] = 1;

        for (int i = 2; i <= n; ++i) {
        	history[i] = 0;
        	// calculate each level's possibility
        	for (int j = 0; j < i; ++j) {
        		history[i] += history[j] * history[i - j - 1];
        	}
        }

        return history[n];
    }
}