package backjoon.Implementation.Q1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        String result;

        switch(m) {
            case 2, 3, 11:
                d += 3;
                break;
            case 4, 7:
                d += 6;
                break;
            case 5:
                d += 1;
                break;
            case 6:
                d += 4;
                break;
            case 8:
                d += 2;
                break;
            case 9, 12:
                d += 5;
                break;
            default:
                d += 0;
        }

        switch(d % 7) {
            case 1:
                result = "MON";
                break;
            case 2:
                result = "TUE";
                break;
            case 3:
                result = "WED";
                break;
            case 4:
                result = "THU";
                break;
            case 5:
                result = "FRI";
                break;
            case 6:
                result = "SAT";
                break;
            default:
                result = "SUN";
        }

        System.out.println(result);
    }
}
