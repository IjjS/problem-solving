class MyQueue {
    
    Deque<Integer> main;
    Deque<Integer> temp;

    public MyQueue() {
        main = new ArrayDeque<>();
        temp = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while(!main.isEmpty()) temp.push(main.pop());
        
        main.push(x);
        
        while(!temp.isEmpty()) main.push(temp.pop());
    }
    
    public int pop() {
        return main.pop();
    }
    
    public int peek() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}