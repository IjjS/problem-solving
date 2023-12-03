package backjoon.Implementation.Q11021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t;) {

            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(++i).append(": ").append(a + b);

            System.out.println(sb);

            sb.setLength(0);
        }

        br.close();
    }
}
