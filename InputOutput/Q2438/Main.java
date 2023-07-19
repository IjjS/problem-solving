package InputOutput.Q2438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {

            for (int j=0; j<=i; j++) {
                sb.append("*");
            }

            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
