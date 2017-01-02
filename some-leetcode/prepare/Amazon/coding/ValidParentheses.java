import java.util.*;

public class ValidParentheses {
    public static int isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int pair = 0;
        for (int i = 0; i < s.length(); ++i) {
        	char cur = s.charAt(i);
        	if (isFirstHalf(cur)) {
        		stack.push(cur);
        	}
        	else {
        		if (stack.isEmpty() || stack.pop() != getFirstHalf(cur)) {
        			return -1;
        		}
        		++pair;
        	}
        }
        
        if (stack.size() != 0) {
        	return -1;
        }
        return pair;
    }

    private static boolean isFirstHalf(char cur) {
    	if (cur == '(' || cur == '{' || cur == '[') {
    		return true;
    	}
    	return false;
    }

    private static char getFirstHalf(char cur) {
    	if (cur == ')') {
    		return '(';
    	}
    	else if (cur == '}') {
    		return '{';
    	}
    	else {
    		return '[';
    	}
    }

    public static void main(String[] args) {
    	String s = "{{}}(({[]}))";
    	System.out.println(ValidParentheses.isValid(s));
    }
}
