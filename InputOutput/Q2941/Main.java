package InputOutput.Q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        br.close();

        int count = str.length();

        for (int i=0; i<str.length(); i++) {
            if (i + 1 == str.length()) break;

            if (str.charAt(i) == 'c' && (str.charAt(i + 1) == '-' || str.charAt(i + 1) == '=')) count--;
            if (str.charAt(i) == 'd' && str.charAt(i + 1) == '-') count--;
            if (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') count--;
            if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') count--;
            if (str.charAt(i) == 's' && str.charAt(i + 1) == '=') count--;
            if (str.charAt(i) == 'z') {
                if (str.charAt(i+1) == '=') {
                    count--;
                    if (i!=0 && str.charAt(i-1) == 'd') count--;
                }
            }
        }

        System.out.println(count);
    }
}
