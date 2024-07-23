import java.io.*;
import java.util.*;

public class Main {
    
    static int sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rows = new int[n];
        
        backTrack(rows, 0);
        System.out.println(sum);
    }
    
    static void backTrack(int[] rows, int index) {
        if (index == rows.length) {
            sum++;
            
            return;
        }
        
        for (int i = 0; i < rows.length; i++) {
            rows[index] = i;
            
            boolean isPossible = true;
            
            for (int j = 0; j < index; j++) {
                if (rows[index] == rows[j] || (Math.abs(index - j) - Math.abs(rows[index] - rows[j]) == 0)) {
                    isPossible = false;
                    
                    break;
                }
            }
            
            if (isPossible) {
                backTrack(rows, index + 1);
            }
        }
    }
    
}
