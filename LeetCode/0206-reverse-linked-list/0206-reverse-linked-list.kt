class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        return reverse(head, null)
    }
    
    fun reverse(head: ListNode?, prev: ListNode?): ListNode? {
        if (head == null) return prev
        
        val next = head.next
        
        head.next = prev
        
        return reverse(next, head)
    }
}