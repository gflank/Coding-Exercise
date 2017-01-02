public class NumArray {
    private class TreeNode {
        int sum, begin, end;
        TreeNode left, right;
        
        public TreeNode(int sum, int begin, int end) {
            this.sum = sum;
            this.begin = begin;
            this.end = end;
            left = null;
            right = null;
        }
    }

    private TreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin > end) return null;
        TreeNode cur = new TreeNode(0, begin, end);
        if (begin == end) {
            cur.sum = nums[begin];
        }
        else {
            int mid = begin + (end - begin) / 2;
            cur.left = buildTree(nums, begin, mid);
            cur.right = buildTree(nums, mid + 1, end);
            cur.sum = cur.left.sum + cur.right.sum;
        }
        return cur;
    }

    public void update(int i, int val) {
        updateHelper(i, val, root);
    }
    
    private void updateHelper(int i, int val, TreeNode cur) {
        if (cur.begin == i && cur.end == i) {
            cur.sum = val;
        }
        else {
            int left = 0, right = 0;
            int mid = cur.begin + (cur.end - cur.begin) / 2;
            if (i <= mid) {
                updateHelper(i, val, cur.left);
            }
            else {
                updateHelper(i, val, cur.right);
            }
            cur.sum = cur.left.sum + cur.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumHelper(i, j, root);
    }
    
    private int sumHelper(int i, int j, TreeNode cur) {
        if (cur.begin == i && cur.end == j) {
            return cur.sum;
        }
        else {
            int mid = cur.begin + (cur.end - cur.begin) / 2;
            if (i > mid) {
                return sumHelper(i, j, cur.right);
            }
            else if (j <= mid) {
                return sumHelper(i, j, cur.left);
            }
            else {
                return sumHelper(i, mid, cur.left) + sumHelper(mid + 1, j, cur.right);
            }
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);