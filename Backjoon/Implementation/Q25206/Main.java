package Backjoon.Implementation.Q25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        int pCounter = 0;
        float sum = 0;

        while ((str=br.readLine())!=null) {
            st = new StringTokenizer(str, " ");
            st.nextToken();
            float credit = Float.parseFloat(st.nextToken());
            String letterGrade = st.nextToken();

            sum += credit * convertGrade(letterGrade);

            if (!letterGrade.equals("P")) pCounter+=credit;
        }

        System.out.println(sum/pCounter);
    }

    public static float convertGrade(String grade) {
        float gpa = 0;

        if (grade.length() == 1) return 0;

        switch (grade.charAt(0)) {
            case 'A':
                gpa = 4;
                break;
            case 'B':
                gpa = 3;
                break;
            case 'C':
                gpa = 2;
                break;
            case 'D':
                gpa = 1;
                break;
        }

        if (grade.charAt(1) == '+') return gpa + 0.5f;
        return gpa;
    }
}
