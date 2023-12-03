package backjoon.Implementation.Q10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numArray = new int[n];

        br.close();

        int min = 10000000;
        int max = -10000000;

        for(int i=0; i<n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<numArray.length; i++) {
            if (numArray[i] > max) max = numArray[i];
            if (numArray[i] < min) min = numArray[i];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(min).append(" ").append(max);

        System.out.print(sb);
    }
}
