
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
    
    	int size;
    	TreeNode curr;
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

    		result.add(path);
    	}

        Collections.reverse(result);
    	return result;
    }
}