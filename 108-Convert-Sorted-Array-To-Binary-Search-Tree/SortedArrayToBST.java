
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
    	if (nums == null) {
    		return null;
    	}

		return helper(nums, 0, nums.length -1);        
    }

    // return the builded TreeNode in the range between start and end
    public TreeNode helper(int[] nums, int start, int end) {
    	if (start > end) {
    		return null;
    	}

    	TreeNode node = new TreeNode(nums[(start + end) / 2]);
    	node.left = helper(nums, start, (start + end) / 2 - 1);
    	node.right = helper(nums, (start + end) / 2 + 1, end);
    	return node;
    }
}
