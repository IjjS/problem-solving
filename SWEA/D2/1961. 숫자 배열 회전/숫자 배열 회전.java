import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			String[][] nums = new String[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					nums[i][j] = st.nextToken();
				}
			}
			
			StringBuilder[][] strings = new StringBuilder[n][3];
			StringBuilder answer = new StringBuilder("#")
					.append(t)
					.append("\n");
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (strings[i][0] == null) {
						strings[i][0] = new StringBuilder();
					}
					
					if (strings[i][1] == null) {
						strings[i][1] = new StringBuilder();
					}
					
					if (strings[i][2] == null) {
						strings[i][2] = new StringBuilder();
					}
					
					strings[i][0].append(nums[n - j - 1][i]);
					strings[i][1].append(nums[n - i - 1][n - j - 1]);
					strings[i][2].append(nums[j][n - i - 1]);
				}
				
				for (int j = 0; j < 3; j++) {
					answer.append(strings[i][j])
						.append(" ");
				}
				
				answer.append("\n");
			}
			
			System.out.print(answer);
		}
	}

}