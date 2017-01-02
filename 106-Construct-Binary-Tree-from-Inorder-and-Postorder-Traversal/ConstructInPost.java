
import java.util.*;

public class ConstructInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
        	return null;
        }
        if (inorder == null) {
        	return null;
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    	if (inStart > inEnd) {
    		return null;
    	}

    	TreeNode root = new TreeNode(postorder[postEnd]);
    	int rootIndex = getPostion(inorder, inStart, inEnd, root.val);
    	root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - 1 - inStart);
    	root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1);

    	return root;
    }

    private int getPostion(int[] nums, int start, int end, int target) {
    	for (int i = start; i <= end; ++i) {
    		if (nums[i] == target) {
    			return i;
    		}
    	}
		return -1;
    }

}