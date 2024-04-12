import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Map<Integer, List<Integer>> components = new HashMap<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      boolean[] discovered = new boolean[n + 1];
      int count = 0;
      
      init(br, components, m);
      
      for (int i = 1; i <= n; i++) {
          if (!dfs(components, i, discovered)) {
              continue;
          }
          
          count++;
      }
      
      System.out.println(count);
    }
    
    private static void init(BufferedReader br, Map<Integer, List<Integer>> components, int m) throws IOException {
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            components.computeIfAbsent(u, val -> new ArrayList<>())
                .add(v);
            components.computeIfAbsent(v, val -> new ArrayList<>())
                .add(u);
        }
    }
    
    private static boolean dfs(Map<Integer, List<Integer>> components, int u, boolean[] discovered) {
        if (discovered[u]) {
            return false;
        }
        
        discovered[u] = true;
        
        if (!components.containsKey(u)) {
            return true;
        }
        
        for (int nextU : components.get(u)) {
            dfs(components, nextU, discovered);
        }
        
        return true;
    }
}