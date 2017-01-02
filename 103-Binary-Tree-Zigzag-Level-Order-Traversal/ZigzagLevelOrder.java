
import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int size;
        TreeNode curr;
        Boolean reverse = false;
        while (!queue.isEmpty()) {
        	ArrayList<Integer> path = new ArrayList<Integer>();
        	size = queue.size();
        	for (int i = 0; i < size; ++i) {
        		curr = queue.poll();
        		path.add(curr.val);
        		if (curr.left != null) {
        			queue.offer(curr.left);
        		}
        		if (curr.right != null) {
        			queue.offer(curr.right);
        		}
        	}

        	if (reverse) {
        		Collections.reverse(path);
        	}
        	reverse = !reverse;
        	result.add(path);
        }

        return result;
    }
}