package Backjoon.Implementation.Q2522;

import static java.lang.Math.abs;

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

        for (int i=0; i<2*n-1; i++) {

            for (int j=n-1; j>=n-1-i; j--) {

                if (i<n) {

                    stars[j] = '*';
                }

                else {

                    stars[i-n] = ' ';
                }
            }

            System.out.println(stars);
        }
    }
}
