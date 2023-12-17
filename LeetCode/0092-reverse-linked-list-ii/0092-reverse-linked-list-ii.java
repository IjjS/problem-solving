class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || right - left == 0) return head;
        
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode start = root;
        
        for (int i = 0; i < left - 1; i++) start = start.next;
        
        ListNode end = start.next;
        
        for (int i = 0; i < right - left; i++) {
            ListNode next = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = next;
        }
        
        return root.next;
    }
}