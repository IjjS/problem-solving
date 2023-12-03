package backjoon.BruteForce.Q2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        br.close();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> cds = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            if (k==1) {
                System.out.println(1);
                return;
            }
            if (n%i==0) cds.add(i);
        }

        if (k > cds.size()) System.out.println(0);
        else System.out.println(cds.get(k-1));
    }
}
