// iteration version
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            if (root.val > target) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return res;
    }
}


// recursive
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int curVal = root.val;
        
        // choose where to go
        TreeNode next;
        if ((double)root.val > target) {
            next = root.left;
        }
        else if ((double)root.val < target) {
            next = root.right;
        }
        else {
            return curVal;
        }
        
        if (next == null) {
            return curVal;
        }
        
        // get children's closest value
        int childVal = closestValue(next, target);
        
        // return the closest one
        if (Math.abs((double)curVal - target) <= Math.abs((double)childVal - target)) {
            return curVal;
        }
        else {
            return childVal;
        }
    }
}

