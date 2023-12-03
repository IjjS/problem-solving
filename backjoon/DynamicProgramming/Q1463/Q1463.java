package backjoon.DynamicProgramming.Q1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        int op[] = new int[n+1];

        for (int i=0; i<=n; i++) {
            if (i==0) {
                op[i] = 0;
                continue;
            }

            if (i==1) {
                op[i] = 0;
                continue;
            }

            op[i] = op[i-1] + 1;

            if (i%2==0) op[i] = Math.min(op[i/2] + 1, op[i]);
            if (i%3==0) op[i] = Math.min(op[i/3] + 1, op[i]);
            System.out.print(i + " ");
            System.out.println(op[i]);
        }

        System.out.print(op[n]);
    }
}
