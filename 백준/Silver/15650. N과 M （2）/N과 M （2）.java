import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		boolean[] visited = new boolean[n + 1];
	
		backTrack(n, m, nums, visited, 0);
	}
	
	static void backTrack(int n, int m, int[] nums, boolean[] visited, int current) {
		if (current == m) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < m; i++) {
				sb.append(nums[i])
					.append(" ");
			}
			
			System.out.println(sb);
			
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (current != 0 && nums[current - 1] >= i || visited[i]) {
				continue;
			}
			
			visited[i] = true;
			nums[current] = i;
			
			backTrack(n, m, nums, visited, current + 1);
			
			visited[i] = false;
		}
	}

}