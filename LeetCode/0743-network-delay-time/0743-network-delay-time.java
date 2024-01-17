class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        
        pq.add(new int[] {k, 0});
        
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            
            if (!dist.containsKey(node)) {
                dist.put(node, cost);
                
                if (dist.get(node) < cost) continue;
                
                if (graph.containsKey(node)) {
                    for (int next : graph.get(node).keySet()) {
                        int alt = cost + graph.get(node).get(next);
                        
                        pq.add(new int[] {next, alt});
                    }
                }
            }
        }
        
        if (dist.size() == n) {
            return Collections.max(dist.values());
        }
        
        return -1;
    }
}