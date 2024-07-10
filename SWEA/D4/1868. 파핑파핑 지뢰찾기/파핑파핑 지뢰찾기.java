import java.util.*;
import java.io.*;
 
public class Solution {
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= cases; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] mines = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int[] xDir = {-1, 0, 1, -1, 1, -1, 0, 1};
            int[] yDir = {-1, -1, -1, 0, 0, 1, 1, 1};           
             
            for (int i = 0; i < n; i++) {
                String st = br.readLine();
                 
                for (int j = 0; j < n; j++) {
                    if (st.charAt(j) == '*') {
                        mines[i][j] = -1;
                         
                        for (int k = 0; k < xDir.length; k++) {
                            int newX = i + xDir[k];
                            int newY = j + yDir[k];
                             
                            if (newX < 0 || newX >= n || newY < 0 || newY >= n || mines[newX][newY] < 0) {
                                continue;
                            }
                             
                            mines[newX][newY] = 1;
                        }
                    }
                }
            }
             
            Queue<int[]> queue = new LinkedList<>();
            int answer = 0;
             
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] || mines[i][j] != 0) {
                        continue;
                    }
                     
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                     
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        int x = node[0];
                        int y = node[1];
                         
                        for (int k = 0; k < xDir.length; k++) {
                            int newX = x + xDir[k];
                            int newY = y + yDir[k];
                             
                            if (newX < 0 || newX >= n || newY < 0 || newY >= n || visited[newX][newY]) {
                                continue;
                            }
                             
                            if (mines[newX][newY] == 0) {
                                queue.add(new int[] {newX, newY});
                            }
                             
                            if (mines[newX][newY] > 0) {
                                mines[newX][newY] = 0;
                            }
                             
                            visited[newX][newY] = true;
                        }
                    }
                     
                    answer++;
                }
            }
             
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mines[i][j] > 0 && !visited[i][j]) {
                        answer++;
                    }
                }
            }
             
            System.out.println("#" + t + " " + answer);
        }
    }
     
}