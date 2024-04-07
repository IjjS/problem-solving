import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String runner : completion) {
            map.put(runner, map.getOrDefault(runner, 0) + 1);
        }
        
        for (String runner : participant) {
            if (!map.containsKey(runner)) {
                return runner;
            }
            
            if (map.get(runner) == 1) {
                map.remove(runner);
                continue;
            }
            
            map.put(runner, map.get(runner) - 1);
        }
        
        return map.entrySet()
            .iterator()
            .next()
            .getKey();
    }
}