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
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return dfs(root, Integer.MIN_VALUE, 0, 1);
    }
    
    private int dfs(TreeNode root, int prev, int count, int max) {
        // terminate condition is reach null
        if (root == null) {
            return Math.max(max, count);
        }
        // if not consecutive, reset count
        if (root.val != prev + 1) {
            max = Math.max(max, count);
            count = 0;
        }
        
        return Math.max(dfs(root.left, root.val, count + 1, max), dfs(root.right, root.val, count + 1, max));
    }
}