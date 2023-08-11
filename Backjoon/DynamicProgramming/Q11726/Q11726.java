package Backjoon.DynamicProgramming.Q11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        int res[] = new int[n];

        res[0]=1;
        if (n>1) res[1]=2;

        for (int i=2; i<n; i++) res[i]=(res[i-1]+res[i-2])%10007;

        System.out.println(res[n-1]);
    }
}
