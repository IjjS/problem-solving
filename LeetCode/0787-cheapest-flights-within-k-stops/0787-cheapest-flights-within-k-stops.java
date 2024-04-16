class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<List<Integer>>> graph = initGraph(flights);
        Map<Integer, List<Integer>> prices = new HashMap<>();
        Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i.get(1)));
        
        queue.add(List.of(src, 0, 0));
        
        return getDestinationPrice(queue, prices, dst, k, graph);
    }
    
    private Map<Integer, List<List<Integer>>> initGraph(int[][] flights) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], val -> new ArrayList<>())
                .add(List.of(flight[1], flight[2]));
        }
        
        return graph;
    }
    
    private int getDestinationPrice(Queue<List<Integer>> queue, Map<Integer, List<Integer>> prices, int dst, int k, Map<Integer, List<List<Integer>>> graph) {
        while(!queue.isEmpty()) {
            List<Integer> flight = queue.poll();
            int destination = flight.get(0);
            int price = flight.get(1);
            int stops = flight.get(2);
            
            if (prices.containsKey(destination) && stops + 1 > prices.get(destination).get(1)) {
                continue;
            }
            
            if (destination == dst) {
                return price;
            }
            
            if (stops <= k) {
                prices.put(destination, List.of(price, stops));
                
                if (!graph.containsKey(destination)) {
                    continue;
                }
                
                for (List<Integer> next : graph.get(destination)) {
                    int newPrice = price + next.get(1);
                    
                    queue.add(List.of(next.get(0), newPrice, stops + 1));
                }
            }
        }
        
        return -1;
    }
}