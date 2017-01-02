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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        
        dfs(root, "", res);
        return res;
    }
    
    private void dfs(TreeNode root, String path, List<String> res) {
        if (root.right == null && root.left == null) {
            res.add(path + root.val);
        }
        
        if (root.left != null) {
            dfs(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            dfs(root.right, path + root.val + "->", res);
        }
    }
}

/*public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(root, sb, res);
        return res;
    }
    
    private void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        
        sb.append("->");
        // record the original length
        int index = sb.length();
        dfs(root.left, sb, res);
        // delete the added on tail
        sb.delete(index, sb.length());
        dfs(root.right, sb, res);
        // delete the added on tail including ->
        sb.delete(index - 2, sb.length());
    }
}*/