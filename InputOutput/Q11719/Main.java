package InputOutput.Q11719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuilder sb = new StringBuilder();

        while((str=br.readLine()) != null) {

            sb.append(str).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
