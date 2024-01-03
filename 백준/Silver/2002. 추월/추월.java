import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      Map<String, Integer> hm = new HashMap<>();
      int[] arr = new int[n];
      int speedings = 0;
      
      for (int i = 0; i < n; i++) {
          String carIn = br.readLine();
          hm.put(carIn, i);
      }
      
      for (int i = 0; i < n; i++) {
          String carOut = br.readLine();
          arr[i] = hm.get(carOut);
      }
      
      for (int i = 0; i < n - 1; i++) {
          for (int j = i + 1; j < n; j++) {
              if (arr[i] > arr[j]) {
                  speedings++;
                  break;
              }
          }
      }
      
      System.out.println(speedings);
    }
}