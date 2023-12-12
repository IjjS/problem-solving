import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m
        String counts = br.readLine();
        StringTokenizer st = new StringTokenizer(counts);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // n numbers & 구간 합 배열 생성
        String inputs = br.readLine();
        st = new StringTokenizer(inputs);
        int[] sum = new int[n + 2];

        sum[0] = 0;
        sum[n] = 0;

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 구간 합 출력
        for (int i = 1; i <= m; i++) {
             String bounds = br.readLine();
             st = new StringTokenizer(bounds);
             int lowerBound = Integer.parseInt(st.nextToken()) - 1;
             int upperBound = Integer.parseInt(st.nextToken());

             System.out.println(sum[upperBound] - sum[lowerBound]);
        }

        br.close();
    }
}