import java.util.*;

public class TwoSumBST {
	public boolean findPair(TreeNode root, int target) {
		if (root == null) {
			return false;
		}

		Stack<TreeNode> stackLeft = new Stack<TreeNode>();
		Stack<TreeNode> stackRight = new Stack<TreeNode>();

		pushLeft(root, stackLeft);
		pushRight(root, stackRight);

		TreeNode left = stackLeft.pop();
		TreeNode right = stackRight.pop();

		while (left.val < right.val) {
			if (left.val + right.val == target) {
				return true;
			}
			// if smaller, need to move left pointer
			else if (left.val + right.val < target) {
				left = stackLeft.pop();
				pushLeft(left.right, stackLeft);
			}
			// if larger, need to move right pointer
			else {
				right = stackRight.pop();
				pushRight(right.left, stackRight);
			}
		}

		return false;
	}

	private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

	private void pushRight(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(15);
    	root.left = new TreeNode(10);
    	root.right = new TreeNode(20);
    	root.left.left = new TreeNode(8);
    	root.left.right = new TreeNode(12);
    	root.right.left = new TreeNode(16);
    	root.right.right = new TreeNode(25);

    	int target = 33;
    	TwoSumBST test = new TwoSumBST();
    	System.out.println(test.findPair(root, target));
    }
}
