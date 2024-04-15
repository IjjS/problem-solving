class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        fun initGraph(): Map<Int, List<Destination>> {
            val graph: MutableMap<Int, MutableList<Destination>> = mutableMapOf()
            
            for (time in times) {
                graph.computeIfAbsent(time[0]){ mutableListOf() }
                    .add(Destination(time[1], time[2]))
            }
            
            return graph
        }
        
        val graph: Map<Int, List<Destination>> = initGraph()
        val distances: MutableMap<Int, Int> = mutableMapOf()
        val queue: Queue<Destination> = PriorityQueue(Comparator.comparingInt({ d -> d.distance }))
        
        queue.add(Destination(k, 0))
        
        fun updateDistance() {
            while(!queue.isEmpty()) {
                val destination: Destination = queue.poll()
                val node: Int = destination.node
                val distance: Int = destination.distance
                
                if (distances.containsKey(node)) {
                    continue
                }
                
                distances[node] = distance
                
                if (!graph.containsKey(node)) {
                    continue
                }
                
                for (nextDestination in graph[node]!!) {
                    val nextDistance: Int = distance + nextDestination.distance
                    
                    queue.add(Destination(nextDestination.node, nextDistance))
                }
            }
        }
        
        updateDistance()
        
        return if (distances.size != n) -1 else Collections.max(distances.values)
    }
    
    class Destination(val node: Int, val distance: Int) {
    }
}