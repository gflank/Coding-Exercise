
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// public class PathSumII {
// 	private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    
//     // find correct path and modified the result list
//     private void findPathHelper(TreeNode root, ArrayList<Integer> path, int sum, int pathSum) {
//     	path.add(root.val);
// 		pathSum += root.val;
// 		// if touch the bottom, check the path sum
//     	if (root.left == null && root.right == null) {
//     		if (pathSum == sum) {
//     			result.add(new ArrayList<Integer>(path));
//     		}
//     	}

//     	if (root.left != null) {
//     		findPathHelper(root.left, path, sum, pathSum);
//     	}
//     	if (root.right != null) {
//     		findPathHelper(root.right, path, sum, pathSum);
//     	}

//     	// this node is already visited, now remove it from the path
// 		path.remove(path.size() - 1);
// 		return;
//     }

//     public List<List<Integer>> pathSum(TreeNode root, int sum) {
//     	if (root == null) {
//     		return result;
//     	}
// 	    // ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
// 	    ArrayList<Integer> path = new ArrayList<Integer>();

//     	findPathHelper(root, path, sum, 0);
//     	return result;
//     }

//     public static void main(String[] args) {
//     	PathSumII A = new PathSumII();
//     	TreeNode root = new TreeNode(1);
//     	System.out.println(A.pathSum(root, 1));
//     }
// }

// rewrote version
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, res);
        return res;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        // reach the bottom
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
        }
        path.add(root.val);
        dfs(root.left, sum - root.val, path, res);
        dfs(root.right, sum - root.val, path, res);
        path.remove(path.size() - 1);
    }
}