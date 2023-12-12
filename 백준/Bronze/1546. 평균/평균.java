import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int oldGrade[] = new int[n];
        
        br.close();
        
        int max = 0;
        for (int i=0; i<n; i++) {
            oldGrade[i] = Integer.parseInt(st.nextToken());
            if (oldGrade[i]>max) max = oldGrade[i];
        }
        
        double fakeSum = 0;
        
        for (int i=0; i<n; i++) fakeSum += (double)oldGrade[i]/max;
        
        System.out.print(fakeSum*100/n);
    }
}