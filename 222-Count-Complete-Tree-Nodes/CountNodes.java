
public class CountNodes {
	// /*normal recursion surpass time limit*/
	// private int nodeNum = 0;

 //    public int countNodes(TreeNode root) {
 //        if (root == null) {
 //        	return 0;
 //        }

 //        ++nodeNum;
 //        countNodes(root.left);
 //        countNodes(root.right);

 //        return nodeNum;
 //    }

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int leftHeight = 0;
		int rightHeight = 0;
		TreeNode left = root.left;
		TreeNode right = root.right;
		while (left != null) {
			++leftHeight;
			left = left.left;
		}
		while (right != null) {
			++rightHeight;
			right = right.right;
		}
		if (leftHeight == rightHeight) {
			return (int) Math.pow(2, leftHeight + 1) - 1;
		}

		else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
    }
}