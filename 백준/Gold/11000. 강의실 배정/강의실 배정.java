import java.io.*;
import java.util.*;

public class Main {
    
    static class Lecture {
        final int start;
        final int end;
        
        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        StringTokenizer st;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            lectures.add(new Lecture(start, end));
        }
        
        lectures.sort((l1, l2) -> l1.start != l2.start ? l1.start - l2.start : l1.end - l2.end);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (Lecture lecture : lectures) {
            if (pq.isEmpty()) {
                pq.add(lecture.end);
                continue;
            }
            
            if (pq.peek() > lecture.start) pq.add(lecture.end);
            else {
                pq.remove();
                pq.add(lecture.end);
            }
        }
        
        System.out.println(pq.size());
    }
}