import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	
	static int[][] map;
	static Queue<int[]> queue;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		queue = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 1) {
					continue;
				}
				
				queue.add(new int[] { i, j, 0 });
			}
		}
		
		int day = bfs();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					day = -1;
					
					break;
				}
			}
		}
		
		System.out.println(day);
	}
	
	static int bfs() {
		int maxDay = 0;
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int nextRow = next[0];
			int nextCol = next[1];
			int day = next[2];
			
			for (int i = 0; i < 4; i++) {
				int newRow = nextRow + dr[i];
				int newCol = nextCol + dc[i];
				
				if (!isInMap(newRow, newCol) || map[newRow][newCol] != 0) {
					continue;
				}
				
				map[newRow][newCol] = 1;
				maxDay = Math.max(maxDay, day + 1);
				
				queue.add(new int[] { newRow, newCol, day + 1 });
			}
		}
		
		return maxDay;
	}
	
	static boolean isInMap(int row, int col) {
		return row >= 0
				&& row < n
				&& col >= 0
				&& col < m;
	}
	
}
