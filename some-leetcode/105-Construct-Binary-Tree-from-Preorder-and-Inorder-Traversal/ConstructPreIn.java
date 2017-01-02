
import java.util.*;

public class ConstructPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
        	return null;
        }
        if (preorder == null) {
        	return null;
        }

        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

        return root;
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    	if (preStart > preEnd) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[preStart]);
    	int rootIndex = getPosition(inorder, inStart, inEnd, root.val);
    	root.left = helper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1);
    	root.right = helper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd);

    	return root;
    }

    private int getPosition(int[] nums, int start, int end, int target) {
        int i;
        for (i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // private int binarySearch(int[] nums, int start, int end, int target) {
    // 	// int start = 0;
    // 	// int end = nums.length - 1;
    // 	int mid;

    // 	while (start + 1 < end) {
    // 		mid = start + (end - start) / 2;
    // 		if (nums[mid] > target) {
    // 			end = mid;
    // 		}
    // 		else if (nums[mid] < target) {
    // 			start = mid;
    // 		}
    // 		else {
    // 			return mid;
    // 		}
    // 	}

    // 	if (nums[start] == target) {
    // 		return start;
    // 	}
    // 	if (nums[end] == target) {
    // 		return end;
    // 	}

    // 	return -1;
    // }

    public static void main(String[] args) {
    	ConstructPreIn A = new ConstructPreIn();
    	int[] preorder = {1, 2, 3};
    	int[] inorder = {3, 2, 1};
    	A.buildTree(preorder, inorder);
    }
}