import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] oldArr = new char[r][c];
        
        for (int i = 0; i < r; i++) oldArr[i] = br.readLine().toCharArray();
        
        char[][] newArr = new char[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) newArr[i][j] = oldArr[j][i];
        }
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < c; i++) set.add(String.valueOf(newArr[i]));
        
        int count = 0;
        
        for (int i = 1; i < r; i++) {
            Set<String> res = new HashSet<>();
            
            for (String item : set) {
                res.add(item.substring(1));
            }
            
            if (res.size() != c) break;
            
            count++;
            set.clear();
            set.addAll(res);
        }
        
        System.out.println(count);
    }
}