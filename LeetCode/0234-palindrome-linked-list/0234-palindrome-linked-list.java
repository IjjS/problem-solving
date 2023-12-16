class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fastRunner = head;
        ListNode slowRunner = head;
        int length = 1;
        
        if (head.next == null) return true;
        
        while (fastRunner.next != null) {
            if (fastRunner.next.next == null) {
                fastRunner = fastRunner.next;
                length++;
            }
            
            else {
                fastRunner = fastRunner.next.next;
                length += 2;
            }
            
            slowRunner = slowRunner.next;
        }
        
        if (length % 2 != 0) slowRunner = slowRunner.next;
        
        ListNode rev = null;
        
        while (slowRunner != null) {
            ListNode next = slowRunner.next;
            slowRunner.next = rev;
            rev = slowRunner;
            slowRunner = next;
        }
        
        while (rev != null) {
            if (rev == null) return false;
            if (rev.val != head.val) return false;
            
            rev = rev.next;
            head = head.next;
        }
        
        return true;
    }
}