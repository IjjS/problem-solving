package backjoon.Implementation.Q1924.Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        br.close();

        int[] daysPerMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] dayOfWeek = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        for(int i=1; i<month; i++) {
            day += daysPerMonth[i-1];
        }

        System.out.print(dayOfWeek[day%7]);
    }
}
