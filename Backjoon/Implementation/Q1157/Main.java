package Backjoon.Implementation.Q1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();

        br.close();

        int count[] = new int[26];
        int max = 0;
        int index = 0;
        int multipleCount = 0;

        for (int i=0; i<count.length; i++) count[i] = 0;

        for (int i=0; i<str.length(); i++) if (++count[str.charAt(i)-'a']>max) max = count[str.charAt(i)-'a'];
        for (int i=0; i<count.length; i++) {
            if (count[i]==max) {
                multipleCount++;
                index = i;
            }
        }

        if (multipleCount>1) System.out.print("?");
        else System.out.print((char)(index+65));
    }
}
