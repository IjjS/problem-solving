import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        int sum = 1;
        int count = 1;
        int start = 1;
        int end = 1;

        while (end != n) {
            if (sum == n) {
                count++;
                sum += (++end - start++);
            }
            if (sum < n) sum += ++end;
            if (sum > n) sum -= start++;
        }

        System.out.println(count);
    }
}
