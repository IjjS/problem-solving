class MyStack {

    Queue<Integer> main;
    Queue<Integer> temp;

    public MyStack() {
        main = new LinkedList<>();
        temp = new LinkedList<>();
    }
    
    public void push(int x) {
        temp.add(x);
        pileUpStack();
        swap();
    }
    
    public int pop() {
        return main.poll();
    }
    
    public int top() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
    
    private void pileUpStack() {
        while (!main.isEmpty()) {
            temp.add(main.poll());
        }
    }

    private void swap() {
        while (!temp.isEmpty()) {
            main.add(temp.poll());
        }
    }
}