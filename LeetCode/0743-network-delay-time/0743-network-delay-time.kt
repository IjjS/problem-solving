class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        fun initGraph(): Map<Int, List<Pair<Int, Int>>> {
            val graph: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()
            
            for (time in times) {
                graph.computeIfAbsent(time[0]){ mutableListOf() }
                    .add(Pair(time[1], time[2]))
            }
            
            return graph
        }
        
        val graph: Map<Int, List<Pair<Int, Int>>> = initGraph()
        val distances: MutableMap<Int, Int> = mutableMapOf()
        val queue: Queue<Pair<Int, Int>> = PriorityQueue(Comparator.comparingInt({ p -> p.second }))
        
        queue.add(Pair(k, 0))
        
        fun updateDistance() {
            while(!queue.isEmpty()) {
                val (node, distance) = queue.poll()
                
                if (distances.containsKey(node)) {
                    continue
                }
                
                distances[node] = distance
                
                if (!graph.containsKey(node)) {
                    continue
                }
                
                for ((nextNode, nextDistance) in graph[node]!!) {
                    queue.add(Pair(nextNode, distance + nextDistance))
                }
            }
        }
        
        updateDistance()
        
        return if (distances.size != n) -1 else Collections.max(distances.values)
    }
}