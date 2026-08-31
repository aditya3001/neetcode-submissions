class MinStack {

    private Stack<Integer> intStack;
    private Stack<Integer> minStack;



    public MinStack() {
        intStack = new Stack<>();
        minStack = new Stack<>();

    }
    
    public void push(int val) {
        intStack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
            return;
        }
        minStack.push(Math.min(val, minStack.peek()));
    }
    
    public void pop() {
        intStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return intStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
