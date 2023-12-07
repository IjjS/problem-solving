import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int basket[] = new int[n];
        
        int temp = 0;
        
        for (int i=0; i<n;) basket[i]=++i;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ballOne = Integer.parseInt(st.nextToken())-1;
            int ballTwo = Integer.parseInt(st.nextToken())-1;
            
            temp = basket[ballOne];
            basket[ballOne] = basket[ballTwo];
            basket[ballTwo] = temp;
        }
        
        br.close();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<n; i++) sb.append(basket[i]).append(" ");
        
        System.out.print(sb);
    }
}