// Binary Search Tree Iterator Total Accepted: 18158 Total Submissions: 62226 My Submissions Question Solution 
// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Hide Tags Tree Stack

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class BSTIterator {

	// private Stack<TreeNode> stack = new Stack<TreeNode>();
	// private TreeNode current;

	// private void pushLeft(TreeNode node) {
	// 	while (node != null) {
	// 		stack.push(node);
	// 		node = node.left;
	// 	}
	// }

 //    public BSTIterator(TreeNode root) {
	// 	while (!stack.isEmpty()) {
	// 		stack.pop();
	// 	}
	// 	current = root;        
 //    }

 //    /** @return whether we have a next smallest number */
 //    public boolean hasNext() {
 //        return current != null || !stack.isEmpty();
 //    }

 //    /** @return the next smallest number */
 //    public int next() {
 //    	// push all left into the stack, achieve the in-order traversal
 //    	pushLeft(current);

 //        current = stack.pop();
	// 	int val = current.val;
	// 	if (current.right != null) {
	// 		pushLeft(current.right);
	// 	}
		
	// 	return val;
 //    }


	private Stack<TreeNode> stack = new Stack<TreeNode>();

	private void pushLeft(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public BSTIterator (TreeNode root) {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		pushLeft(root);
	}

	public Boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TreeNode current = stack.pop();
		int val = current.val;
		if (current.right != null) {
			pushLeft(current.right);
		}

		return val;
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */