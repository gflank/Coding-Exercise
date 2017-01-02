// Binary Tree Inorder Traversal Total Accepted: 67512 Total Submissions: 186347 My Submissions Question Solution 
// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?

// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// Hide Tags Tree Hash Table Stack

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
	/* recursion version*/
    // private ArrayList<Integer> result = new ArrayList<Integer>();

    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if (root == null) {
    //     	return new List<Integer>();
    //     }

    //     inorderTraversal(root.left);
    //     result.add(root.val);
    //     inorderTraversal(root.right);

    //     return result;
    // }

	/*stack version*/
	private ArrayList<Integer> result = new ArrayList<Integer>();
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	private void pushLeft(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}

		pushLeft(root);
		TreeNode current;
		while (!stack.isEmpty()) {
			current = stack.pop();
			result.add(current.val);
			if (current.right != null) {
				pushLeft(current.right);
			}
		}

		return result;
	}
}