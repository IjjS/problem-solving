import java.io.*;
import java.util.*;

public class Main {
    
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int l = Integer.parseInt(st.nextToken());
       StringBuilder sb = new StringBuilder();
       char[] chars = br.readLine()
               .replace(" ", "")
               .toCharArray();
       
       Arrays.sort(chars);
       
       combine(l, 0, 0, chars, new StringBuilder(), 0, sb);
       System.out.println(sb);
    }
    
    static void combine(int l, int vowelCount, int consonentCount, char[] chars, StringBuilder word, int index, StringBuilder sb) {
        if (word.length() == l) {
            if (vowelCount >= 1 && consonentCount >= 2) {
                sb.append(word)
                    .append(System.lineSeparator());
            }
            
            return;
        }
        
        for (int i = index; i < chars.length; i++) {
            boolean isVowel = false;
            
            if (vowels.contains(chars[i])) {
                isVowel = true;
                vowelCount++;
            } else {
                consonentCount++;
            }
            
            combine(l, vowelCount, consonentCount, chars, word.append(chars[i]), i + 1, sb);
            
            if (isVowel) {
                vowelCount--;
            } else {
                consonentCount--;
            }
            
            word.deleteCharAt(word.length() - 1);
        }
    }
}