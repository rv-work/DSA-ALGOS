// [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)


class MyQueue {
    // Main stack to store elements
    Stack<Integer> st = new Stack<>();
    // Helper stack for operations
    Stack<Integer> helper = new Stack<>();

    
    public MyQueue() {
        
    }
    
    // Add an element to the queue
    public void push(int x) {
        st.add(x);
    }
    
    // Remove and return the element at the front of the queue
    public int pop() {
        // Move all elements except the last one to helper stack
        while (st.size() > 1) {
            helper.add(st.pop());
        }
        // Get the last element (front of the queue)
        int val = st.pop();
        // Move all elements back to main stack
        while (!helper.isEmpty()) {
            st.add(helper.pop());
        }
        return val;
    }
    
    // Return the element at the front of the queue without removing it
    public int peek() {
        // Move all elements except the last one to helper stack
        while (st.size() > 1) {
            helper.add(st.pop());
        }
        // Get the last element (front of the queue)
        int val = st.pop();
        // Put the element back
        st.add(val);
        // Move all elements back to main stack
        while (!helper.isEmpty()) {
            st.add(helper.pop());
        }
        return val;
    }
    
    // Check if the queue is empty
    public boolean empty() {
        return st.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */