import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        br.close();

        Deque<Character> word = new ArrayDeque<>();
        Queue<Character> tag = new LinkedList<>();
        boolean isWord = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                isWord = false;

                while (!word.isEmpty()) sb.append(word.pop());

                System.out.print(sb);
                sb.setLength(0);
            }

            if (input.charAt(i) == ' ' && isWord) {
                while (!word.isEmpty()) sb.append(word.pop());

                sb.append(' ');

                System.out.print(sb);
                sb.setLength(0);

                continue;
            }

            if (isWord) {
                word.push(input.charAt(i));
            } else {
                tag.add(input.charAt(i));
            }

            if (input.charAt(i) == '>') {
                isWord = true;

                while (!tag.isEmpty()) sb.append(tag.poll());

                System.out.print(sb);
                sb.setLength(0);
            }

            if (i == input.length() - 1) {
                while (!word.isEmpty()) sb.append(word.pop());

                System.out.print(sb);
                sb.setLength(0);
            }
        }
    }
}