class MyHashMap() {
    class Node(var key: Int, var value: Int) {
        var next: Node? = null
    }
    
    val nodes: Array<Node?> = arrayOfNulls(1000001)

    fun put(key: Int, value: Int) {
        val index: Int = key % nodes.size
        
        if (nodes[index] == null) {
            nodes[index] = Node(key, value)
            return
        }
        
        var node: Node? = nodes[index]
        
        while (node != null) {
            if (node.key == key) {
                node.value = value
                return
            }
            if (node.next == null) {
                break
            }
            
            node = node.next
        }
        
        node!!.next = Node(key, value)
    }

    fun get(key: Int): Int {
        var index: Int = key % nodes.size
        
        if (nodes[index] == null) {
            return -1
        }
        
        var node: Node? = nodes[index]
        
        while (node != null) {
            if (node.key == key) {
                return node.value
            }
            
            node = node.next
        }
        
        return -1
    }

    fun remove(key: Int) {
        val index: Int = key % nodes.size
        
        if (nodes[index] == null) {
            return
        }
        
       	var node: Node? = nodes[index]
        
        if (node!!.key == key) {
            nodes[index] = node?.next
            return
        }
        
        var prev: Node? = node
        
        while (node != null) {
            if (node.key == key) {
                prev?.next = node.next
                return
            }
            
            prev = node
            node = node.next
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */