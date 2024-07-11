import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		StringBuilder sb = new StringBuilder();
	
		backTrack(n, m, nums, 0, sb);
		
		System.out.println(sb);
	}
	
	static void backTrack(int n, int m, int[] nums, int current, StringBuilder sb) {
		if (current == m) {
			for (int i = 0; i < m; i++) {
				sb.append(nums[i])
					.append(" ");
			}

			sb.append(System.lineSeparator());
			
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (current != 0 && nums[current - 1] > i) {
				continue;
			}
			
			nums[current] = i;
			
			backTrack(n, m, nums, current + 1, sb);
		}
	}

}