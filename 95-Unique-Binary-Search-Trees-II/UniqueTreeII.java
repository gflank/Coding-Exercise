// Unique Binary Search Trees II Total Accepted: 32082 Total Submissions: 114881 My Submissions Question Solution 
// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// Hide Tags Tree Dynamic Programming

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class UniqueTreeII {
    public List<TreeNode> generateTrees(int n) {
    	return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	if (start > end) {
    		result.add(null);
    		return result;
    	}

    	List<TreeNode> left, right;
    	for (int i = start; i <= end; ++i) {
    		left = helper(start, i - 1);
    		right = helper(i + 1, end);
    		for (TreeNode l : left) {
    			for (TreeNode r : right) {
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				result.add(root);
    			}
    		}
    	}

    	return result;
    }
}
