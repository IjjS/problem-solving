class MyCircularQueue {
    
    int[] cq;
    int index;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        cq = new int[k];
        index = 0;
        front = 0;
        rear = 0;

        Arrays.fill(cq, -1);
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        cq[index] = value;
        rear = index;
        
        index++;

        if (index == cq.length) index = 0;
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        cq[front] = -1;
        
        if (front == cq.length - 1) front = 0;
        else front++;
        
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : cq[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : cq[rear];
    }
    
    public boolean isEmpty() {
        return cq[front] == -1;
    }
    
    public boolean isFull() {
        if (isEmpty()) return false;

        return front == 0 ? rear == cq.length - 1 : rear == front - 1;
    }
}