// Recover Binary Search Tree Total Accepted: 33048 Total Submissions: 136412 My Submissions Question Solution 
// Two elements of a binary search tree (BST) are swapped by mistake.

// Recover the tree without changing its structure.

// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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

import java.util.*;

public class RecoverTree {
	private ArrayList<TreeNode> error = new ArrayList<TreeNode>();
	private TreeNode last = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
        	return;
        }

        helper(root);
        if (error.size() == 2) {
        	int temp = error.get(0).val;
        	error.get(0).val = error.get(1).val;
        	error.get(1).val = temp;
        }
        else {
        	int temp = error.get(0).val;
        	error.get(0).val = error.get(3).val;
        	error.get(3).val = temp;        	
        }
    }

    private void helper(TreeNode root) {
    	if (root == null) {
    		return;
    	}

    	helper(root.left);
    	if (last != null) {
    		if (last.val > root.val) {
    			error.add(last);
    			error.add(root);
    		}
    	}
    	last = root;
    	helper(root.right);
    }
}