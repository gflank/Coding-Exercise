
public class RightSide {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int size;
        queue.offer(root);
        TreeNode temp;
        int flag;
        result.add(root.val);
        while (!queue.isEmpty()) {
        	size = queue.size();
        	flag = 0;
        	for (int i = 0; i < size; ++i) {
        		temp = queue.peek();
        		queue.poll();
        		if (temp.right != null) {
        			queue.offer(temp.right);
        			if (flag == 0) {
        				result.add(temp.right.val);
        				flag = 1;
        			}
        		}
        		if (temp.left != null) {
        			queue.offer(temp.left);
        			if (flag == 0) {
        				result.add(temp.left.val);
        				flag = 1;
        			}
        		}
        	}
        }

        return result;
    }
}
