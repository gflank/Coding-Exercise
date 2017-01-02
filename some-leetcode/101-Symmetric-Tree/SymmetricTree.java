
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
    		return true;
    	}

        return symHelper(root.left, root.right);
    }

    public boolean symHelper(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
    		return true;
    	}
    	else if (left != null && right != null) {
    		return left.val == right.val && symHelper(left.left, right.right) && symHelper(left.right, right.left);
    	}
    	else {
    		return false;
    	}
    }
}