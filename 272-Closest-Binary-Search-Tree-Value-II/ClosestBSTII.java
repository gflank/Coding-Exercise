// O(klgN) solution with stacks
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initSucc(root, target, succ);
        initPred(root, target, pred);
        if (!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) getPred(pred);
        
        int num = 0;
        while (num < k) {
            ++num;
            if (succ.isEmpty()) res.add(getPred(pred));
            else if (pred.isEmpty()) res.add(getSucc(succ));
            else {
                double succDiff = Math.abs((double)succ.peek().val - target);
                double predDiff = Math.abs((double)pred.peek().val - target);
                if (succDiff < predDiff) {
                    res.add(getSucc(succ));
                }
                else {
                    res.add(getPred(pred));
                }
            }
        }
        return res;
    }
    
    private void initSucc(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if ((double)root.val == target) {
                succ.push(root);
                return;
            }
            else if ((double)root.val > target) {
                succ.push(root);
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
    }
    
    private void initPred(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if ((double)root.val == target) {
                pred.push(root);
                return;
            }
            else if ((double)root.val < target) {
                pred.push(root);
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
    }
    
    private int getSucc(Stack<TreeNode> succ) {
        int ret = succ.peek().val;
        TreeNode next = succ.pop().right;
        while (next != null) {
            succ.push(next);
            next = next.left;
        }
        return ret;
    }
    
    private int getPred(Stack<TreeNode> pred) {
        int ret = pred.peek().val;
        TreeNode next = pred.pop().left;
        while (next != null) {
            pred.push(next);
            next = next.right;
        }
        return ret;
    }
}


// improved O(n) solution with queue
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> queue = new LinkedList<>();
        inorder(root, target, k, queue);
        return (List)queue;
    }
    
    // return true means truely end, false means 
    private boolean inorder(TreeNode root, double target, int k, Queue<Integer> queue) {
        if (root == null) return false;
        
        if (inorder(root.left, target, k, queue)) return true;
        
        if (queue.size() == k) {
            if (Math.abs((double)queue.peek() - target) < Math.abs((double)root.val - target)) {
                return true;
            }
            queue.poll();
        }
        queue.offer(root.val);
        
        return inorder(root.right, target, k, queue);
    }
}


// inorder travelsal solution with heap
public class Solution {
    private class Candidate {
        int val;
        double diff;
        public Candidate(int val, double diff) {
            this.val = val;
            this.diff = diff;
        }
    }
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        PriorityQueue<Candidate> maxHeap = new PriorityQueue<Candidate>((a, b) -> {
                if (b.diff == a.diff) return 0;
                else if (b.diff > a.diff) return 1;
                else return -1;
            });
        inorder(root, target, k, maxHeap);
        for (Candidate c : maxHeap) {
            res.add(c.val);
        }
        return res;
    }
    
    private void inorder(TreeNode root, double target, int k, PriorityQueue<Candidate> maxHeap) {
        if (root == null) return;
        inorder(root.left, target, k, maxHeap);
        
        maxHeap.offer(new Candidate(root.val, Math.abs((double)root.val - target)));
        if (maxHeap.size() > k) {
            // early pruning
            if (root.val == maxHeap.poll().val) {
                return;
            }
        }
        
        inorder(root.right, target, k, maxHeap);
    }
}