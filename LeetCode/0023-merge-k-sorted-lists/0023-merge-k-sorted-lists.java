class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> {
            if (n1.val == n2.val) return 0;
            if (n1.val > n2.val) return 1;
            else return -1;
        });
        
        ListNode root = new ListNode(0);
        ListNode end = root;
        
        for (ListNode list : lists) {
            if (list == null) continue;
            
            pq.add(list);
        }
        
        while (!pq.isEmpty()) {
            end.next = pq.poll();
            end = end.next;
            
            if (end.next != null) pq.add(end.next);
        }
        
        return root.next;
    }
}