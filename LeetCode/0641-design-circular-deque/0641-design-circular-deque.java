class MyCircularDeque {
    static class DoubleNode {
        DoubleNode prev;
        DoubleNode next;
        int val;
        
        DoubleNode(int val) {
            this.val = val;
        }
    }
    
    DoubleNode head = new DoubleNode(0);
    DoubleNode tail = new DoubleNode(0);
    int len = 0;
    int max = 0;

    public MyCircularDeque(int k) {
        max = k;
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        
        DoubleNode node = new DoubleNode(value);
        
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        
        len++;
        
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        
        DoubleNode node = new DoubleNode(value);
        
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        
        len++;
        
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        
        head.next.next.prev = head;
        head.next = head.next.next;
        
        len--;
        
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        
        len--;
        
        return true;
    }
    
    public int getFront() {
        return (isEmpty()) ? -1 : head.next.val;
    }
    
    public int getRear() {
        return (isEmpty()) ? -1 : tail.prev.val;
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == max;
    }
}