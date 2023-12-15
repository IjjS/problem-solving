class MyCircularQueue(k: Int) {
    var q = IntArray(k)
    var front = 0
    var rear = -1
    var len = 0

    fun enQueue(value: Int): Boolean {
        if (!isFull()) {
            rear = ++rear % q.size
            q[rear] = value
            
            len++
            
            return true
        }
        
        return false
    }

    fun deQueue(): Boolean {
        if (!isEmpty()) {
            front = ++front % q.size
            
            len--
            
            return true
        }
        
        return false
    }

    fun Front(): Int {
        if (isEmpty()) return -1
        
        return q[front]
    }

    fun Rear(): Int {
        if (isEmpty()) return -1
        
        return q[rear]
    }

    fun isEmpty(): Boolean {
        return len == 0
    }

    fun isFull(): Boolean {
        return len == q.size
    }

}