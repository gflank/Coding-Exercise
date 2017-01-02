// Binary Tree Maximum Path Sum Total Accepted: 40101 Total Submissions: 187402 My Submissions Question Solution 
// Given a binary tree, find the maximum path sum.

// The path may start and end at any node in the tree.

// For example:
// Given the below binary tree,

//        1
//       / \
//      2   3
// Return 6.

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
public class MaxPath {
    private int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
        	return Integer.MIN_VALUE;
        }
        maxDownPath(root);

        return globalMax;
    }

    public int maxDownPath(TreeNode root) {
    	int left = Integer.MIN_VALUE;
    	int right = Integer.MIN_VALUE;
    	if (root.left != null) {
    		left = maxDownPath(root.left);
    	}
    	if (root.right != null) {
    		right = maxDownPath(root.right);
    	}

    	int localMax = root.val;
    	if (left > 0) {
    		localMax += left;
    	}
    	if (right > 0) {
    		localMax += right;
    	}

    	// update the global max value here 
    	globalMax = Math.max(globalMax, localMax);

    	//return the max down path value(bottom up)
    	if (left <= 0 && right <= 0) {
    		return root.val;
    	}
    	else {
    		return root.val + Math.max(left, right);
    	}
    }
}
