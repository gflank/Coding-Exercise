/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //binary version
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int cur = countNodes(root.left) + 1;
        if (cur == k) {
            return root.val;
        }
        else if (cur < k) {
            return kthSmallest(root.right, k - cur);
        }
        else {
            return kthSmallest(root.left, k);
        }
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// recursion version
// public class Solution {
//     private int count = 0;
//     private int res = 0;
    
//     public int kthSmallest(TreeNode root, int k) {
//         helper(root, k);
        
//         return res;
//     }
    
//     private void helper(TreeNode root, int k) {
//         if (root == null) {
//             return;
//         }

//         helper(root.left, k);
        
//         ++count;
//         if (count == k) {
//             res = root.val;
//         }

//         helper(root.right, k);
//     }
// }