
public class ConvertList {
    // private class ResultType {
    //  TreeNode root; // builder TreeNode, or k/2 th TreeNode
    //  ListNode node; // k + 1 th ListNode 
    // }

	private ListNode current; // store the k + 1 th node

	private int getLength(ListNode head) {
		int size = 0;
		while (head != null) {
			++size;
			head = head.next;
		}
		return size;
	}

    public TreeNode sortedListToBST(ListNode head) {

    	current = head;
    	int n = getLength(head); // O(n)
    	return convertHelper(n); // O(n)
        // return convertHelper(head, n).root; // O(n)
    }

    // convert the first k nodes(current as begin) to a balanced BST and return
    public TreeNode convertHelper(int k) {
        if (k <= 0) {
    		return null;
    	}

    	TreeNode left = convertHelper((k - 1) / 2);
    	TreeNode root = new TreeNode(current.val);
    	current = current.next;
    	TreeNode right = convertHelper(k - 1 - (k - 1) / 2);

    	root.left = left;
    	root.right = right;
    	return root;
    }

    // convert the first k nodes(head as begin) to a balanced BST and return
    // public ResultType convertHelper(ListNode head, int k) {
        // if (k == 0) {
        //  return new ResultType(null, null);
        // }
        // if (k == 1) {
        //  return new ResultType(new TreeNode(head.val), head);
        // }

        // ResultType left = convertHelper(head, (k - 1) / 2);
        // TreeNode root = new TreeNode(left.node.val);
        // ResultType right = convertHelper(left.node.next, k - 1 - (k - 1) / 2);
        // root.left = left.root;
        // root.right = right.root;

     //    return new ResultType{root, right.node.next};

}
