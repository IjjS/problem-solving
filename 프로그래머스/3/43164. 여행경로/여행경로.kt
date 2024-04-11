import java.util.*;

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val destinations: MutableMap<String, PriorityQueue<String>> = mutableMapOf()
        val answer: MutableList<String> = mutableListOf()
        
        for (ticket in tickets) {
            destinations.computeIfAbsent(ticket[0]){ PriorityQueue() }
                .add(ticket[1])
        }
        
        fun dfs(departure: String) {
            while (destinations[departure]?.isNotEmpty() == true) {
                dfs(destinations[departure]!!.poll())
            }
            
            answer.add(0, departure)
        }
        
        dfs("ICN")
        
        return answer.toTypedArray()
    }
}