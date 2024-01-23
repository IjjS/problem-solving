import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) return a - b;
            
            return Math.abs(a) - Math.abs(b);
        });
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                if (pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()).append("\n");
                continue;
            }
            
            pq.add(num);
        }
        
        System.out.println(sb);
    }
}