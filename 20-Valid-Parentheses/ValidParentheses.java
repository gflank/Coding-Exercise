public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (isFirst(cur)) {
                stack.push(cur);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != getPair(cur)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isFirst(char first) {
        if (first == '(' || first == '[' || first == '{') {
            return true;
        }
        return false;
    }

    private char getPair(char second) {
        if (second == ')') {
            return '(';
        }
        else if (second == ']') {
            return '[';
        }
        else {
            return '{';
        }
    }
}


// import java.util.*;

// public class ValidParentheses {
//     public boolean isValid(String s) {
//         if (s.equals("") || s.length() == 0) {
//         	return true;
//         }

//         Stack<Character> stack = new Stack<Character>();
//         ArrayList<Character> formatFront = new ArrayList<Character>();
//         formatFront.add('(');
//         formatFront.add('{');
//         formatFront.add('[');
//         ArrayList<Character> formatBack = new ArrayList<Character>();
//         formatBack.add(')');
//         formatBack.add('}');
//         formatBack.add(']');

//         for (Character c : s.toCharArray()) {
//         	if (formatFront.contains(c)) {
//         		stack.push(c);
//         	}
//         	else if (formatBack.contains(c)) {
//         		if (!stack.isEmpty() && helper(stack.peek(), c)) {
//         			stack.pop();
//         		}
//         		else {
//         			return false;
//         		}
//         	}
//         	else {
//         		return false;
//         	}
//         }

//         return stack.isEmpty();
//     }

//     private boolean helper(char c1, char c2) {
//     	return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
//     }
// }