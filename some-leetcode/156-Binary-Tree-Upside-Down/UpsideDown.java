
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
    // recursion version
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        
        root.left = null;
        root.right = null;
        
        return newRoot;
    }

    // iteration version
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode next = null;
        TreeNode prev = null;
        TreeNode prevRight = null;
        TreeNode cur = root;
        
        while (cur != null) {
            next = cur.left;
            cur.left = prevRight;
            prevRight = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}

