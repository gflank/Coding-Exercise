// Invert Binary Tree Total Accepted: 5546 Total Submissions: 14777 My Submissions Question Solution 
// Invert a binary tree.

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// to
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
// Trivia:
// This problem was inspired by this original tweet by Max Howell:
// Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
// Hide Tags Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) {
    		return null;
    	}

    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;

    	invertTree(root.left);
		invertTree(root.right);

		return root;        
    }
}