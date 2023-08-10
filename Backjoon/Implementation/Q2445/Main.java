package Backjoon.Implementation.Q2445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        char stars[] = new char[2*n];

        for (int i=0; i<2*n; i++) {
            stars[i] = ' ';
        }

        for (int i=0; i<2*n-1; i++) {

            for (int j=0; j<=i; j++) {

                if (i<n) {
                    stars[j] = '*';
                    stars[2*n-1-i] = '*';
                }

                else {
                    stars[i] = ' ';
                    stars[2*n-1-i] = ' ';
                }
            }

            System.out.println(stars);
        }
    }
}
