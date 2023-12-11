class MyQueue {
    
    Stack<Integer> main = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        while (!main.empty()) {
            temp.push(main.pop());
        }
        
        temp.push(x);
        
        while (!temp.empty()) {
            main.push(temp.pop());
        }
    }
    
    public int pop() {
        return main.pop();
    }
    
    public int peek() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.empty();
    }
}