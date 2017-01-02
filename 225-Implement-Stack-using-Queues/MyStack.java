class MyStack {
    Queue<Integer> mainQueue = new LinkedList<>();
    Queue<Integer> tempQueue = new LinkedList<>();
    
    // Push element x onto stack.
    public void push(int x) {
        tempQueue.offer(x);
        while (!mainQueue.isEmpty()) {
            tempQueue.offer(mainQueue.poll());
        }
        
        // now swap main and temp
        Queue<Integer> swapper = mainQueue;
        mainQueue = tempQueue;
        tempQueue = swapper;
    }

    // Removes the element on top of the stack.
    public void pop() {
        mainQueue.poll();
    }

    // Get the top element.
    public int top() {
        return mainQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}