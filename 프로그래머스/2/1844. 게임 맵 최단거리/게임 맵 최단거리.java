import java.util.*;

class Solution {
    static class Triple {
        int i;
        int j;
        int distance;
        
        Triple(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
    public int solution(int[][] maps) {
        Queue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.distance));
        
        pq.add(new Triple(0, 0, 1));
        
        return getLastDistance(pq, maps);
    }
    
    private int getLastDistance(Queue<Triple> pq, int[][] maps) {
        while (!pq.isEmpty()) {
            Triple node = pq.poll();
            int i = node.i;
            int j = node.j;
            int distance = node.distance;
            
            if (i == maps.length - 1 && j == maps[0].length - 1) {
                return distance;
            }
            
            updateDistance(i - 1, j, distance, maps, pq);
            updateDistance(i + 1, j, distance, maps, pq);
            updateDistance(i, j - 1, distance, maps, pq);
            updateDistance(i, j + 1, distance, maps, pq);
        }
        
        return -1;
    }
    
    private void updateDistance(int i, int j, int distance, int[][] maps, Queue<Triple> pq) {
        if (i < 0 || i >= maps.length || j < 0 || j >= maps[0].length || maps[i][j] == 0) {
            return;
        }
        
        maps[i][j] = 0;
        
        pq.add(new Triple(i, j, distance + 1));
    }
}