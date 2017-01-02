// import java.util.*;

// public class IsSubTree {
// 	public static class TreeNode {
// 		TreeNode left = null;
// 		TreeNode right = null;
// 		int val;

// 		public TreeNode(int val) {
// 			this.val = val;
// 		}
// 	}

// 	// judge whether T2 is a subtree of T1
// 	// considering only the values, not necessarily the same nodes
// 	// first locate to the starting node (notice not BST!)
// 	public boolean isSubtree(TreeNode T1, TreeNode T2) {
// 		// T2 is null, true
// 		if (T2 == null) {
// 			return true;
// 		}
// 		// T1 is null means not found, false
// 		else if (T1 == null) {
// 			return false;
// 		}
		
// 		// matched, start to match the remain subtree
// 		if (T1.val  == T2.val) {
// 			// may match or not
// 			if (judge(T1, T2)) {
// 				return true;
// 			}
// 		}
// 		return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
// 	}

// 	// judge() is used to check if value match in every pair
// 	private boolean judge(TreeNode T1, TreeNode T2) {
// 		if (T1 == null && T2 == null) {
// 			return true;
// 		}
// 		else if (T1 == null || T2 == null) {
// 			return false;
// 		}
// 		if (T1.val != T2.val) {
// 			return false;
// 		}
// 		return judge(T1.left, T2.left) && judge(T1.right, T2.right);
// 	}
// }


// rewrote
public class Solution {
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
		// first to find out where to start
		if (T2 == null) {
			return true;
		}
		else if (T1 == null) {
			return false;
		}

		// if values match, start examing same tree
		if (T1.val == T2.val) {
			if (isSameTree(T1, T2)) {
				return true;
			}
		}
		// other wise continue searching for the starting point
		return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    private boolean isSameTree(TreeNode T1, TreeNode T2) {
    	if (T1 == null && T2 == null) {
    		return true;
    	}
    	else if ((T1 == null || T2 == null) || T1.val != T2.val) {
    		return false;
    	}
    	return isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right);
    }
}