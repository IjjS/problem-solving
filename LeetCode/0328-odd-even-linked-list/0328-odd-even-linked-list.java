class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode oddRoot = new ListNode(0);
        ListNode oddNode = oddRoot;
        ListNode evenRoot = new ListNode(0);
        ListNode evenNode = evenRoot;
        int count = 0;
        
        while (head != null) {
            count++;
            
            if (count % 2 == 0) {
                evenNode.next = head;
                evenNode = evenNode.next;
            }
            
            else {
                oddNode.next = head;
                oddNode = oddNode.next;
            }
            
            head = head.next;
        }
        
        if (evenNode.next != null) evenNode.next = null;
        
        oddNode.next = evenRoot.next;
        
        return oddRoot.next;
    }
}