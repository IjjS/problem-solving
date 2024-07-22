import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int[] answer = new int[m];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        backTrack(m, nums, answer, 0, 0, sb);
        System.out.println(sb);
    }
    
    static void backTrack(int m, int[] nums, int[] answer, int current, int index, StringBuilder sb) {
        if (current == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i])
                    .append(" ");
            }
            
            sb.append(System.lineSeparator());
            
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            
            answer[current] = nums[i];
            
            backTrack(m, nums, answer, current + 1, i, sb);
        }
    }

}