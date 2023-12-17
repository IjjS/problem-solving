class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val l1Num = toBigInteger(reverse(l1))
        val l2Num = toBigInteger(reverse(l2))
        val result = l1Num.add(l2Num)
        
        return toReversedList(result)
    }
    
    fun reverse(head: ListNode?): ListNode? {
        var node = head
        var rev: ListNode? = null
        
        while (node != null) {
            val next = node.next
            node.next = rev
            rev = node
            node = next
        }
        
        return rev
    }
    
    fun toBigInteger(head: ListNode?): BigInteger {
        var node = head
        var str = ""
        
        while (node != null) {
            str += node.`val`
            node = node.next
        }
        
        return BigInteger(str)
    }
    
    fun toReversedList(value: BigInteger): ListNode? {
        var prev: ListNode? = null
        var node: ListNode? = null
        
        for (c in "$value") {
            node = ListNode(Character.getNumericValue(c))
            node.next = prev
            prev = node
        }
        
        return node
    }
}