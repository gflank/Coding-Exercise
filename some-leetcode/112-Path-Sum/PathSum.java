// Path Sum Total Accepted: 55255 Total Submissions: 185271 My Submissions Question Solution 
// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \      \
//         7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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
public class PathSum {
    // public boolean hasPathSum(TreeNode root, int sum) {
    // 	return pathSum(root, sum, 0);
    // }

    // public boolean pathSum(TreeNode root, int sum, int parentSum) {
    // 	if (root == null) {
    // 		return false;
    // 	}

    // 	if (parentSum + root.val == sum) {
    // 		if (parentSum != 0 || (root.left == null && root.right == null)) {
	   //  		return true;
    // 		}
    // 	}

    // 	return pathSum(root.left, sum, parentSum + root.val) || pathSum(root.right, sum, parentSum + root.val);
    // }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // judge if we touch the bottom
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}