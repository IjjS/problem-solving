package Backjoon.Implementation.Q10798;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[5];
        int maxLength = 0;

        for (int i=0; i<5; i++) {
            inputs[i] = br.readLine();
            if (inputs[i].length() > maxLength) maxLength = inputs[i].length();
        }

        br.close();

        int index = 0;
        while (true) {
            boolean terminator = true;
            if (inputs[0].length() >= index+1) {
                System.out.print(inputs[0].charAt(index));
                terminator = false;
            }
            if (inputs[1].length() >= index+1) {
                System.out.print(inputs[1].charAt(index));
                terminator = false;
            }
            if (inputs[2].length() >= index+1) {
                System.out.print(inputs[2].charAt(index));
                terminator = false;
            }
            if (inputs[3].length() >= index+1) {
                System.out.print(inputs[3].charAt(index));
                terminator = false;
            }
            if (inputs[4].length() >= index+1) {
                System.out.print(inputs[4].charAt(index));
                terminator = false;
            }
            if (terminator) break;
            index++;
        }
    }
}
