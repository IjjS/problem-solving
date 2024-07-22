import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        backTrack(n, new int[n + 1], 0, new boolean[n + 1], sb);
        
        System.out.println(sb);
    }
    
    static void backTrack(int n, int[] nums, int current, boolean[] visited, StringBuilder sb) {
        if (current == n) {
            for (int i = 0; i < n; i++) {
                sb.append(nums[i])
                    .append(" ");
            }
            
            sb.append(System.lineSeparator());
            
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            nums[current] = i;
            
            backTrack(n, nums, current + 1, visited, sb);
            
            visited[i] = false;
        }
    }

}