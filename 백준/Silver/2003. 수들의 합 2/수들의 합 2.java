import java.io.*;
import java.util.*;

public class Main {
    
    static int total = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            combine(m, nums, i, 0);
        }
        
        System.out.println(total);
    }
    
    static void combine(int m, int[] nums, int index, int sum) {
        if (sum == m) {
            total++;
            
            return;
        }
        
        if (sum > m || index == nums.length) {
            return;
        }
        
        combine(m, nums, index + 1, sum + nums[index]);
    }
}