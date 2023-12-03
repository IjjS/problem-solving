package backjoon.Implementation.Q1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        br.close();

        int sum = 2;
        int boxCount = 0;
        int start = 1;

        while (num >= sum+boxCount) {
            start = sum+boxCount;
            boxCount += sum++-1;
        }

        int numerator = 1 + (num - start);
        int denominator = sum - 1 - (num - start);

        if (sum%2 == 0) {
            int temp = numerator;
            numerator = denominator;
            denominator = temp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(numerator).append("/").append(denominator);

        System.out.println(sb);
    }
}
