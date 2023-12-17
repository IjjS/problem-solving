class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        
        node.next = head;
        
        while (node.next != null && node.next.next != null) {
            ListNode first = node.next;
            ListNode second = node.next.next;
            
            first.next = second.next;
            second.next = first;
            node.next = second;
            node = first;
        }
        
        return root.next;
    }
}