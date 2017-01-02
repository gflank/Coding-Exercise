import java.util.*;

public class SameTree {
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	public static boolean isSameTree(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		else if ((node1 == null || node2 == null) || node1.val != node2.val) {
			return false;
		}
		return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
	}
}
