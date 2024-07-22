import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        br.close();
        
        int opt[] = new int[n+1];
        
        for (int i=0; i<n+1; i++) {
            if (i==0) {
                opt[i]=0;
                continue;
            }
            
            if (i==1) {
                opt[i]=0;
                continue;
            }
            
            opt[i] = opt[i-1]+1;
            
            if (i%3==0) opt[i]=Math.min(opt[i/3]+1, opt[i]);
            if (i%2==0) opt[i]=Math.min(opt[i/2]+1, opt[i]);
        }
        
        System.out.print(opt[n]);
    }
}