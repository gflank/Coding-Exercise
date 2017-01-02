// Implement Queue using Stacks Total Accepted: 4208 Total Submissions: 12168 My Submissions Question Solution 
// Implement the following operations of a queue using stacks.

// push(x) -- Push element x to the back of queue.
// pop() -- Removes the element from in front of queue.
// peek() -- Get the front element.
// empty() -- Return whether the queue is empty.
// Notes:
// You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
// You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
// Hide Tags Stack Data Structure
// Hide Similar Problems (E) Implement Stack using Queues

class MyQueue {
	private Stack<Integer> stackOut = new Stack<Integer>();
	private Stack<Integer> stackIn = new Stack<Integer>();

	private void in2Out() {
		while (!stackIn.isEmpty()) {
			stackOut.push(stackIn.peek());
			stackIn.pop();
		}
	}
    // Push element x to the back of queue.
    public void push(int x) {
        stackIn.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stackOut.isEmpty()) {
        	in2Out();
        }
        stackOut.pop();
    }

    // Get the front element.
    public int peek() {
        if (stackOut.isEmpty()) {
        	in2Out();
        }
        return stackOut.peek();        
    }

    // Return whether the queue is empty.l
    public boolean empty() {
        if (stackOut.isEmpty()) {
        	in2Out();
        }
        return stackOut.isEmpty();
    }
}
