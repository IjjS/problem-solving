import java.io.*;
import java.util.*;

public class Main {
    
    static int permutations = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        permutate(false, s, nums, 0, 0);
        
        System.out.println(permutations);
    }
    
    static void permutate(boolean initialized, int s, int[] nums, int index, int sum) {
        if (sum == s && initialized) {
            permutations++;
        }
        
        for (int i = index; i < nums.length; i++) {            
            permutate(true, s, nums, i + 1, sum + nums[i]);
        }
    }
}