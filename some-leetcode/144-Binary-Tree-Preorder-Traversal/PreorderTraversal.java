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
	// //recursion version
 //    private ArrayList<Integer> result = new ArrayList<Integer>();

 //    public List<Integer> preorderTraversal(TreeNode root) {
 //    	if (root == null) {
 //    		return new ArrayList<Integer>();
 //    	}

 //    	result.add(root.val);
 //    	preorderTraversal(root.left);
 //    	preorderTraversal(root.right);

 //    	return result;
 //    }

    //stack version
    private ArrayList<Integer> result = new ArrayList<Integer>();
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public List<Integer> preorderTraversal(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<Integer>();
    	}

    	stack.push(root);
    	TreeNode current;
    	while (!stack.isEmpty()) {
    		current = stack.pop();
    		result.add(current.val);
    		if (current.right != null) {
    			stack.push(current.right);
    		}
    		if (current.left != null) {
    			stack.push(current.left);
    		}
    	}

    	return result;
    }
}