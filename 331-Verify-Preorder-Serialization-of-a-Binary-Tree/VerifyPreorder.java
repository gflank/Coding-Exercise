// indegree and outdegree solution
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] vals = preorder.split(",");
        int diff = 1;
        for (String cur : vals) {
            if (--diff < 0) return false;
            if (!cur.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}


// stack solution
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) {
            return false;
        }
        
        String[] vals = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String cur : vals) {
            // if cur is number, insert it
            if (!cur.equals("#")) {
                stack.push(cur);
            }
            // if is #, check if compact is possible
            else {
                // if previous is #, try to compact
                if (!stack.isEmpty() && stack.peek().equals("#")) {
                    while (!stack.isEmpty() && stack.peek().equals("#")) {
                        // first value should be null
                        stack.pop();
                        // second value should be not null
                        if (stack.isEmpty() || stack.pop().equals("#")) return false;
                    }
                }
                stack.push(cur);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}