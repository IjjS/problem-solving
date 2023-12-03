package backjoon.Implementation.Q2903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        System.out.println((int)Math.pow(Math.pow(2, n) +1, 2));
    }
}
