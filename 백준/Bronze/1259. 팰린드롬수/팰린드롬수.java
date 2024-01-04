import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str;
        while (!(str = br.readLine()).equals("0")) {
            char[] arr = str.toCharArray();
            int start = 0;
            int last = str.length() - 1;
            boolean flag = true;
            
            while (start < last) {
                if (arr[start] != arr[last]) {
                    flag = false;
                    sb.append("no\n");
                    break;
                }
            
                start++;
                last--;
            }
            
            if (flag) sb.append("yes\n");
        }
        
        System.out.println(sb);
    }
}