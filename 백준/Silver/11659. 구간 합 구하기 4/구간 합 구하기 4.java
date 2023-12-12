import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m
        int n = Integer.parseInt(br.readLine().split(" ")[0]);

        // n numbers & 구간 합 배열 생성
        String inputs = br.readLine();
        StringTokenizer st = new StringTokenizer(inputs);
        int[] sum = new int[n + 2];

        sum[0] = 0;
        sum[n] = 0;

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 구간 합 출력
        String str;
        while((str = br.readLine()) != null) {
             st = new StringTokenizer(str);
             int lowerBound = Integer.parseInt(st.nextToken()) - 1;
             int upperBound = Integer.parseInt(st.nextToken());

             System.out.println(sum[upperBound] - sum[lowerBound]);
        }

        br.close();
    }
}
