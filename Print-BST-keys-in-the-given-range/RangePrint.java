
import java.util.*;

public class RangePrint {
	public void print(TreeNode root, int min, int max) {
		if (root == null) {
			return;
		}
		if (min > max) {
			return;
		}

		/*
		// check value now
		// if in range, query both children
		if (root.val >= min && root.val <= max) {
			print(root.left, min, max);
			// print current value here because current value must be smaller than those in right sub tree
			System.out.println(root.val);
			print(root.right, min, max);
		}
		// if val is smaller, only query right tree
		else if (root.val < min) {
			print(root.right, min, max);
		}
		// otherwise query left tree
		else {
			print(root.left, min, max);
		}
		*/

		// neater version
		// if value > min, query left sub-tree
		if (root.val > min) {
			print(root.left, min, max);
		}
		// if in range, print current value
		if (root.val >= min && root.val <= max) {
			System.out.println(root.val);
		}
		// if value < max, query right sub-tree
		if (root.val < max) {
			print(root.right, min, max);
		}
	}
}
