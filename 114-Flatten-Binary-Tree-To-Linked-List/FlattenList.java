// Flatten Binary Tree to Linked List Total Accepted: 48797 Total Submissions: 169206 My Submissions Question Solution 
// Given a binary tree, flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
// click to show hints.

// Hints:
// If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

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
public class FlattenList {
    private TreeNode curr = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (curr != null) {
            curr.left = null;
            curr.right = root;
        }

        curr = root;
        // write down the real right child of node
        TreeNode rightReal = root.right;
        flatten(root.left);
        flatten(rightReal);
    }

    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }

    //     curr = root;
    //     // write down the real right child of node
    //     TreeNode rightReal = root.right;
    //     flattenHelper(root.left);
    //     flattenHelper(rightReal);
    // }

    // public void flattenHelper(TreeNode node) {
    //     if (node == null) {
    //         return;
    //     }

    //     curr.left = null;
    //     curr.right = node;
    //     curr = node;
    //     // write down the real right child of node
    //     TreeNode rightReal = node.right;
    //     flattenHelper(node.left); 
    //     flattenHelper(rightReal); 
    // }

    // private TreeNode curr = null;

    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }

    //     if (curr != null) {

    //     }

    //     curr = root;
    //     // write down the real right child
    //     TreeNode rightReal = root.right;
    //     flatten(root.left);
    //     flatten(rightReal);
    // }

    public static void main(String[] args) {
        FlattenList A = new FlattenList();
        TreeNode leftChild = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        root.left = leftChild;
        A.flatten(root);
    }
}