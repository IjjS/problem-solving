package backjoon.Implementation.Q2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        char stars[] = new char[n];
        for (int i=0; i<n; i++) {
            stars[i] = ' ';
        }

        for (int i=0; i<n; i++) {

            for (int j=n-1; j>=n-1-i; j--) {
                stars[j] = '*';
            }

            System.out.println(stars);
        }
    }
}
