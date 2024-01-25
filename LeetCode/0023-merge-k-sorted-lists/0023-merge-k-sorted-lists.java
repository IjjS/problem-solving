class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (Objects.nonNull(node)) pq.offer(node);
        }
        
        ListNode root = new ListNode(0);
        ListNode current = root;
        
        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
            
            if (Objects.nonNull(current.next)) pq.offer(current.next);
        }
        
        return root.next;
    }
}