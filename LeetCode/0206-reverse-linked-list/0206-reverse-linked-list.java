class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        
        while (head != null) {
            ListNode next = head.next;
            head.next = reversed;
            reversed = head;
            head = next;
        }
        
        return reversed;
    }
}