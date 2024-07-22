import java.io.*;

public class Main {
    
    static int permutations = 0;
    static int[] given = {1, 2, 3};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            permutate(n, 0);
            
            sb.append(permutations)
                .append(System.lineSeparator());
            
            permutations = 0;
        }
        
        System.out.println(sb);
    }
    
    static void permutate(int n, int sum) {
        if (sum == n) {
            permutations++;
            
            return;
        }
        
        if (sum > n) {
            return;
        }
        
        for (int i = 0; i < given.length; i++) {
            permutate(n, sum + given[i]);
        }
    }

}