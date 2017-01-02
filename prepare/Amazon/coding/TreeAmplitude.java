import java.util.*;

public class TreeAmplitude {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int v) {
			val = v;
			left = null;
			right = null;
		}
	}

	public static int amp(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfs(root, root.val, root.val);
	}

	public static int dfs(TreeNode cur, int min, int max) {
		if (cur == null) {
			return max - min;
		}
		// check the min and max
		min = Math.min(min, cur.val);
		max = Math.max(max, cur.val);
		return Math.max(dfs(cur.left, min, max), dfs(cur.right, min, max));
	}
}