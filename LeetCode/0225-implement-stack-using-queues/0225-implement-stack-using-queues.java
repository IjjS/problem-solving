class MyStack {

    Queue<Integer> inbox;
    Queue<Integer> outbox;

    public MyStack() {
        inbox = new LinkedList<>();
        outbox = new LinkedList<>();
    }
    
    public void push(int x) {
        inbox.add(x);
    }
    
    public int pop() {
        if (inbox.size() < 2) return inbox.poll();
        migrate();
        return outbox.poll();
    }
    
    public int top() {
        if (inbox.size() < 2) return inbox.peek();
        migrate();
        int top = outbox.poll();
        inbox.add(top);
        return top;
    }
    
    public boolean empty() {
        return inbox.isEmpty();
    }

    private void migrate() {
        int size = inbox.size();

        for (int i = 0; i < size; i++) {
            outbox.add(inbox.poll());
        }

        for (int i = 0; i < size - 1; i++) {
            inbox.add(outbox.poll());
        }
    }
}