// Minimum Depth of Binary Tree Total Accepted: 56418 Total Submissions: 193944 My Submissions Question Solution 
// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        return minHelper(root);
    }

    public int minHelper(TreeNode root) {
    	if (root == null) {
    		return Integer.MAX_VALUE;
    	}

    	if (root.left == null && root.right == null) {
    		return 1;
    	}

        int left = minHelper(root.left);
        int right = minHelper(root.right);

        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
    	MinDepth A = new MinDepth();
    	TreeNode p = new TreeNode(2);
    	p.left = null;
    	p.right = null;
		TreeNode q = new TreeNode(1);
    	q.left = p;
    	q.right = null;
    	System.out.println(A.minDepth(q));    
    }
}

// public class Solution {
//     private int min = Integer.MAX_VALUE;
    
//     public int minDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
        
//         traversal(root, 1);
//         return min;
//     }
    
//     private void traversal(TreeNode root, int depth) {
//         if (root == null) {
//             return;
//         }
//         if (root.left == null && root.right == null) {
//             min = Math.min(min, depth);
//             return;
//         }
//         ++depth;
//         traversal(root.left, depth);
//         traversal(root.right, depth);
//     }
// }
