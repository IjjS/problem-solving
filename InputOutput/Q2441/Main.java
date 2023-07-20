package InputOutput.Q2441;

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
            stars[i] = '*';
        }

        for (int i=0; i<n; i++) {

            for (int j=0; j<i; j++) {
                stars[j] = ' ';
            }

            System.out.println(stars);
        }
    }
}
