

import java.util.*;

class MinStack {
	private Stack<Integer> oriStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        oriStack.push(x);
        if (minStack.isEmpty()) {
        	minStack.push(x);
        }
        else {
        	if ((long)x - (long)minStack.peek() <= 0) {
        		minStack.push(x);
        	}
        }
    }

    public void pop() {
        if (oriStack.peek() - minStack.peek() == 0) {
        	minStack.pop();
        }
    	oriStack.pop();
    }

    public int top() {
		return oriStack.peek();        
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
    	MinStack A =  new MinStack();
    	A.push(2147483646);
    	A.push(2147483646);
    	A.push(2147483647);
    	System.out.println(A.top());
    	A.pop();
    	System.out.println(A.getMin());
    	A.pop();
    	System.out.println(A.getMin());
    	A.pop();
    	A.push(2147483647);
    	System.out.println(A.top());
    	System.out.println(A.getMin());
    	A.push(-2147483648);
    	System.out.println(A.top());
    	System.out.println(A.getMin());
    	A.pop();
    	System.out.println(A.getMin());
    }
}
