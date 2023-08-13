package Backjoon.DynamicProgramming.Q11727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q11727 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        int dp[] = new int[n];

        dp[0] = 1;
        if (n>1) dp[1] = 3;

        for (int i=2; i<n; i++) dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        System.out.print(dp[n-1]);
    }
}
