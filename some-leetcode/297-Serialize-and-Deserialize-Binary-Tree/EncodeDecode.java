/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsEncode(root, sb);
        return sb.toString();
    }
    
    // pre-order traversal
    public void dfsEncode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('x').append(',');
            return;
        }
        else {
            sb.append(root.val).append(',');
            dfsEncode(root.left, sb);
            dfsEncode(root.right, sb);
        }
    }

    int decodePos;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        decodePos = 0;
        String[] nodes = data.split(",");
        return dfsDecode(nodes);
    }
    
    private TreeNode dfsDecode(String[] nodes) {
        if (decodePos >= nodes.length) {
            return null;
        }
        
        // start decoding
        if (nodes[decodePos].equals("x")) {
            ++decodePos;
            return null;
        }
        else {
            TreeNode root = new TreeNode(Integer.valueOf(nodes[decodePos]));
            ++decodePos;
            root.left = dfsDecode(nodes);
            root.right = dfsDecode(nodes);
            
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));