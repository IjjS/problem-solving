package backjoon.Implementation.Q11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Character> stack = new Stack<>();

        br.close();

        int dec = Integer.parseInt(st.nextToken());
        int numSys = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (dec!=0) {
            char converted = (dec%numSys>9) ? (char)(dec%numSys+55) : (char)(dec%numSys+'0');
            stack.push(converted);
            dec /= numSys;
        }

        while (!stack.empty()) sb.append(stack.pop());

        System.out.println(sb);
    }
}
