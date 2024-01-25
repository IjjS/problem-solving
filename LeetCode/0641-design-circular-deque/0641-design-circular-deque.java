class MyCircularDeque {
    Node head;
    Node tail;
    int size;
    int max;

    public MyCircularDeque(int k) {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
        max = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        
        Node node = new Node(value);
        
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        
        size++;
        
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        
        Node node = new Node(value);
        
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        
        size++;
        
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;

        head.next = head.next.next;
        head.next.prev = head;
        
        size--;
        
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        
        size--;
        
        return true;
    }
    
    public int getFront() {
        return head.next == tail ? -1 : head.next.value;
    }
    
    public int getRear() {
        return tail.prev == head ? -1 : tail.prev.value;
    }
    
    public boolean isEmpty() {
        return head.next == tail;
    }
    
    public boolean isFull() {
        return size == max;
    }
    
    static class Node {
        Node prev;
        Node next;
        int value;
        
        Node(int value) {
            this.value = value;
            prev = null;
            next = null;
        }
    }
}