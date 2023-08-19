package Backjoon.Implementation.Q2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        br.close();

        int min = 10000;
        int sum = 0;
        boolean[] nonPrimes = new boolean[n+1];

        nonPrimes[0] = true;
        nonPrimes[1] = true;

        //에라토스테네스 체
        for (int i=2; i<n+1; i++) {
            for (int j=i*2; j<n+1; j+=i) {
                if (!nonPrimes[j]) nonPrimes[j] = true;
            }
        }

        for (int i=m; i<n+1; i++) {
            if(!nonPrimes[i]) {
                if (i<min) min=i;
                sum += i;
            }
        }

        if (min==10000) min = -1;

        if (sum!=0) System.out.println(sum);
        System.out.println(min);
    }
}
