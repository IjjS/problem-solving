class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        
        var odd: ListNode = head
        var even = head.next
        val evenHead = even
        
        while (even?.next != null) {
            odd.next = even.next
            even.next = even.next.next
            odd = odd.next
            even = even.next
        }
        
        odd.next = evenHead
        
        return head
    }
}