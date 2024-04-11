class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> destinationMap = new HashMap<>();
        LinkedList<String> results = new LinkedList<>();
        
        for (List<String> ticket : tickets) {
            destinationMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            destinationMap.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs(destinationMap, "JFK", results);
        
        return results;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> destinationMap, String departure, LinkedList<String> results) {
        PriorityQueue<String> destinations = destinationMap.get(departure);
        
        while (destinationMap.containsKey(departure) && !destinations.isEmpty()) {
            dfs(destinationMap, destinations.poll(), results);
        }
        
        results.addFirst(departure);
    }
}