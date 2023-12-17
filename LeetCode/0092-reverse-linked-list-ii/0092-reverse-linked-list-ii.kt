class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head?.next == null || right - left == 0) return head
        
        val root = ListNode(0)
        root.next = head
        var start = root
        
        for (i in 0 until left - 1) start = start.next
        
        var end = start.next
        
        for (i in 0 until right - left) {
            val next = start.next
            start.next = end.next
            end.next = end.next.next
            start.next.next = next
        }
        
        return root.next
    }
}