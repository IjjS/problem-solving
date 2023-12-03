package backjoon.Implementation.Q11022;

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

            System.out.println(result(sb, ++i, a, b));

            sb.setLength(0);
        }
    }
    private static StringBuilder result(StringBuilder sb, int i, int a, int b) {
        String part1 = "Case #";
        String part2 = ": ";
        String part3 = " + ";
        String part4 = " = ";

        return sb.append(part1).append(i).append(part2).append(a).append(part3).append(b).append(part4).append(a + b);
    }
}
