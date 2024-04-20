import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < k; i++) {
            boolean isBipartite = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = initGraph(br, st, v, e);
            int[] groups = new int[v + 1];
            
            for (int j = 1; j < graph.length; j++) {
                if (graph[j] == null) {
                    continue;
                }
                
                if (!dfs(graph, j, 1, groups)) {
                    isBipartite = false;
                    break;
                }
            }
            
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
    
    private static List<Integer>[] initGraph(BufferedReader br, StringTokenizer st, int v, int e) throws IOException {
        List<Integer>[] graph = new ArrayList[v + 1];
        
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            if (graph[start] == null) {
                graph[start] = new ArrayList<>();
            }
            
            if (graph[end] == null) {
                graph[end] = new ArrayList<>();
            }
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        return graph;
    }
    
    private static boolean dfs(List<Integer>[] graph, int start, int group, int[] groups) {
        if (groups[start] != 0) {
            return true;
        }
        
        groups[start] = group;
        
        if (graph[start] == null) {
            return true;
        }
        
        for (int end : graph[start]) {
            if (groups[start] == groups[end]) {
                return false;
            }
            
            int nextGroup = (groups[start] == 1) ? 2 : 1;
            
            if (!dfs(graph, end, nextGroup, groups)) {
                return false;
            }
        }
        
        return true;
    }
}