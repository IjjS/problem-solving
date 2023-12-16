class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        val deque = LinkedList<Int>()
        var node = head
        
        while (node != null) {
            deque.push(node.`val`)
            node = node.next
        }
        
        while (!deque.isEmpty() && deque.size > 1) {
            if (deque.pollFirst() !== deque.pollLast()) return false
        }
        
        return true
    }
}