// stack version
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                }
                else {
                    stack.push(i);
                }
            }
        }
        // if stack is empty, means all match, return len
        if (stack.isEmpty()) {
            return s.length();
        }
        
        // now calculate the max length -> between two adjacent invalid indices
        int longest = 0;
        // the first invalid index should be len
        int prevIndex = s.length(), curIndex;
        while (!stack.isEmpty()) {
            curIndex = stack.pop();
            longest = Math.max(longest, prevIndex - curIndex - 1);
            prevIndex = curIndex;
        }
        // the last invalid index should be -1
        curIndex = -1;
        return Math.max(longest, prevIndex - curIndex - 1);
    }
}

// TLE?? -> wrong answer for "()(()"
// public class Solution {
//     public int longestValidParentheses(String s) {
//         int longest = 0;
//         int count = 0; //  count for '('
//         for (int i = 0; i < s.length(); ++i) {
//             if (s.charAt(i) == '(') {
//                 ++count;
//             }
//             else {
//                 if (count > 0) {
//                     --count;
//                     longest += 2;
//                 }
//             }
//         }
//         return longest;
//     }
// }