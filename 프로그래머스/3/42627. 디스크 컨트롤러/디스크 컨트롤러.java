import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int estimatedEnd = 0;
        int total = 0;
        Queue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.process));
        
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            
            return a[0] - b[0];
        });
        
        for (int[] job : jobs) {
            while (!pq.isEmpty() && estimatedEnd < job[0]) {
                Job working = pq.poll();
                
                estimatedEnd = Math.max(estimatedEnd, working.start) + working.process;
                total += estimatedEnd - working.start;
            }
            
            pq.offer(new Job(job));
        }
        
        while (!pq.isEmpty()) {
            Job working = pq.poll();
            
            estimatedEnd = Math.max(estimatedEnd, working.start) + working.process;
            total += estimatedEnd - working.start;
        }
        
        return total / jobs.length;
    }
    
    static class Job {
        
        int start;
        int process;
        
        Job(int[] job) {
            this.start = job[0];
            this.process = job[1];
        }
        
    }
}