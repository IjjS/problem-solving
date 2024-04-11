class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val destinationMap: MutableMap<String, PriorityQueue<String>> = mutableMapOf()
        val results: MutableList<String> = mutableListOf()
        
        tickets.forEach { ticket ->
            destinationMap.computeIfAbsent(ticket[0]) { PriorityQueue<String>() }
                .add(ticket[1])
        }
        
        fun dfs(departure: String) {
            while (destinationMap[departure]?.isNotEmpty() == true) {
                dfs(destinationMap[departure]!!.poll())
            }
            
            results.add(0, departure)
        }
        
        dfs("JFK")
        
        return results
    }
}