import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        Deque<Integer> deque = new ArrayDeque<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            
            deque.offerLast(i);
        }
        
        while (!deque.isEmpty()) {
            int index = deque.pollFirst();
            int num = nums[index];
            
            sb.append(index + 1);
            
            if (deque.isEmpty()) break;
            
            for (int i = 1; i < num; i++) deque.offerLast(deque.pollFirst());
            
            for (int i = 0; i < -num; i++) deque.offerFirst(deque.pollLast());
            
            sb.append(" ");
        }
        
        System.out.println(sb);
    }
}