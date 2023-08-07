package InputOutput.Q11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int count = input.length() / 10;
        int lastStringLength = input.length() % 10;

        StringBuilder sb = new StringBuilder();

        sb.append(input);

        String str;


        for(int i=0; i<count;) {
            str = sb.substring(i * 10, ++i * 10);
            System.out.println(str);
        }

        str = sb.substring(count * 10, count * 10 + lastStringLength);
        System.out.println(str);

        br.close();
    }
}
