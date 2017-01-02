
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if (p == null && q == null) {
    		return true;
    	}
    	if (p == null || q == null) {
    		return false;
    	}
        if (p.val != q.val) {
        	return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
    	SameTree A = new SameTree();
    	TreeNode p = new TreeNode(0);
    	p.left = null;
    	p.right = null;
		TreeNode q = new TreeNode(0);
    	q.left = null;
    	q.right = null;
    	System.out.println(A.isSameTree(p, q));    
    }
}