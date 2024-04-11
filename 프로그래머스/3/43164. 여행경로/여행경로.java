import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> destinations = new HashMap<>();
        List<String> answer = new LinkedList<>();
        
        for(String[] ticket : tickets) {
            destinations.computeIfAbsent(ticket[0], destination -> new PriorityQueue<>())
                .add(ticket[1]);
        }
        
        dfs(destinations, "ICN", answer);
        
        return answer.toArray(new String[0]);
    }
    
    private void dfs(Map<String, PriorityQueue<String>> destinations, String departure, List<String> answer) {
        while(destinations.containsKey(departure) && !destinations.get(departure).isEmpty()) {
            dfs(destinations, destinations.get(departure).poll(), answer);
        }
        
        answer.add(0, departure);
    }
}