//  [Min Stack](https://leetcode.com/problems/min-stack/)




class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();


    public void push(int x) {
        // agar x min se chhota hai to ye min bhi push kr denge aur fir vo value taki pop krte time agr vo min hoga to uske niche vala hme uss time tak ka min milega 
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}