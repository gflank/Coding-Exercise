import java.util.*;

public class MinPathSum {
	public  static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	// global min sum
	private static int min;

	// using dfs to traverse the tree
	// bfs would not be the best choice because it need to traverse the whole tree
	public static int minPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// reset the global min
		min = Integer.MAX_VALUE;
		dfs(root, 0);
		return min;
	}

	private static void dfs(TreeNode root, int pathSum) {
		if (root.left == null && root.right == null) {
			min = Math.min(min, pathSum + root.val);
			return;
		}

		int temp = pathSum + root.val;
		// only continue if current sum smaller than min
		// early pruning
		if (temp < min) {
			if (root.left != null) {
				dfs(root.left, temp);
			}

			if (root.right != null) {
				dfs(root.right, temp);
			}
		}
	}

	public static void main(String[] args) {
		/* test case 1
                   5
                  / \
                 4   8
                /   / \
               11  13  4
              /  \      \
             7    2      1
           min path: 5 + 8 + 4 + 1 = 18
		*/
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.right = node9;
		System.out.println(MinPathSum.minPathSum(node1));
	}
}