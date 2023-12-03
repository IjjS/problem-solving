package backjoon.Implementation.Q2745;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str = st.nextToken();
        int numSys = Integer.parseInt(st.nextToken());
        int res = 0;

        br.close();

        for (int i=str.length()-1; i>=0; i--) {
            int num =  (str.charAt(i)-'0'>9) ? (str.charAt(i)-55) : (str.charAt(i)-'0');
            res += num * Math.pow(numSys, str.length() - i - 1);
        }
        System.out.println(res);
    }
}
