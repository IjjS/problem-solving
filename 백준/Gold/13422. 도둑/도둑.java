import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] stored = new int[n];
            int sum = 0;
            int answer = 0;
            
            for (int j = 0; j < n; j++) {
                stored[j] = Integer.parseInt(st.nextToken());
                sum += stored[j];
            }
            
            if (n == m) {
                if (sum < k) answer++;
                
                sb.append(answer + "\n");
                continue;
            }
            
            sum = 0;
            
            for (int j = 0; j < m; j++) sum += stored[j];
            
            for (int j = 0; j < n; j++) {
                if (sum < k) answer++;
                sum -= stored[j];
                sum += stored[(j + m) % n];
            }
            
            sb.append(answer + "\n");
        }
        
        System.out.println(sb);
    }
}