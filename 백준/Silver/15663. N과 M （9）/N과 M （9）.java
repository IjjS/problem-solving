import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);

		int[] answer = new int[m];
		boolean[] visited = new boolean[n + 1];
		StringBuilder sb = new StringBuilder();
	
		backTrack(n, m, nums, visited, answer, 0, sb);
		
		System.out.println(sb);
	}
	
	static void backTrack(int n, int m, int[] nums, boolean[] visited, int[] answer, int current, StringBuilder sb) {
		if (current == m) {
			for (int i = 0; i < m; i++) {
				sb.append(answer[i])
					.append(" ");
			}

			sb.append(System.lineSeparator());
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			
			if (i != 0 && nums[i - 1] == nums[i]) {
				if (!visited[i - 1]) {
					continue;
				}
			}
			
			visited[i] = true;
			answer[current] = nums[i];
			
			backTrack(n, m, nums, visited, answer, current + 1, sb);
			
			visited[i] = false;
		}
	}

}