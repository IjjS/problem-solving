import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        boolean[] visited = new boolean[9];
        int[] genuine = new int[7];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(heights);
        combination(heights, visited, genuine, 0, 0, 0);
        
        for (int height : genuine) {
            sb.append(height)
                .append(System.lineSeparator());
        }
        
        System.out.println(sb);
    }
    
    static boolean combination(int[] heights, boolean[] visited, int[] genuine, int current, int index, int sum) {
        if (sum == 100) {
            return true;
        }
        
        if (sum > 100 || current >= 7 || index >= 9) {
            return false;
        }
        
        for (int i = index; i < 9; i++) {
            if (visited[i]) {
                continue;
            }
            
            genuine[current] = heights[i];
            
            if (combination(heights, visited, genuine, current + 1, i + 1, sum + heights[i])) {
                return true;
            }
            
        }
        
        return false;
    }
    
}