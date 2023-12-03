package backjoon.Implementation.Q2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int room = Integer.parseInt(br.readLine());

        int count = 1;
        int roomRange = 2;

        while (roomRange <= room) roomRange += count++*6;

        System.out.println(count);
    }
}
