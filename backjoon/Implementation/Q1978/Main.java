package backjoon.Implementation.Q1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        br.close();

        while (st.hasMoreTokens()) {
            int given = Integer.parseInt(st.nextToken());
            if (given==1) n--;

            for (int i=2; i<=given; i++) {
                if (given%i==0 && i!=given) {
                    n--;
                    break;
                }
            }
        }

        System.out.println(n);
    }
}
