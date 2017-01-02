// Sum Root to Leaf Numbers Total Accepted: 45853 Total Submissions: 151196 My Submissions Question Solution 
// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.

// Return the sum = 12 + 13 = 25.

// Hide Tags Tree Depth-first Search

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	private int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
        	return 0;
        }

        sumHelper(root, 0);

        return totalSum;
    }

    private void sumHelper(TreeNode root, int pathSum) {
    	if (root == null) {
    		return;
    	}

    	pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
        	totalSum += pathSum;
        }

        sumHelper(root.left, pathSum);
        sumHelper(root.right, pathSum);
    }
}