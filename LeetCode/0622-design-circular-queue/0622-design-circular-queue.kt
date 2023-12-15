class MyCircularQueue(k: Int) {
    var q = IntArray(k)
    var front = 0
    var rear = -1
    var len = 0

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false 
        
        rear = ++rear % q.size
        q[rear] = value
            
        len++
        
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        
        front = ++front % q.size
            
        len--
            
        return true
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