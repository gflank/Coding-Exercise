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
    // second solution
    /*
    private int max = 1;
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        traversal(root, 0);
        return max;
    }
    
    private void traversal(TreeNode root, int len) {
        if (root == null) {
            return;
        }
        ++len;
        max = Math.max(max, len);
        
        traversal(root.left, len);
        traversal(root.right, len);
    }
    */
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
