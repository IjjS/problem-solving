import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // s, p 길이
        String conditions = br.readLine();
        StringTokenizer st = new StringTokenizer(conditions);
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // DNA 문자열
        String dna = br.readLine();

        // A, C, G, T 최소 개수
        String minNumStr = br.readLine();
        int[] minNums = new int[4];
        int addition = 0;
        st = new StringTokenizer(minNumStr);

        for (int i = 0; i < 4; i++) {
            minNums[i] = Integer.parseInt(st.nextToken());

            if (minNums[i] == 0) addition++;
        }

        // 풀이
        int count = 0;
        int matchingNums = addition;
        int[] subCounts = new int[4];
        char[] dnaArr = dna.toCharArray();

        for (int i = 0; i < p; i++) {
            switch (dnaArr[i]) {
                case 'A':
                    subCounts[0]++;
                    if (minNums[0] == subCounts[0]) matchingNums++;
                    break;
                case 'C':
                    subCounts[1]++;
                    if (minNums[1] == subCounts[1]) matchingNums++;
                    break;
                case 'G':
                    subCounts[2]++;
                    if (minNums[2] == subCounts[2]) matchingNums++;
                    break;
                case 'T':
                    subCounts[3]++;
                    if (minNums[3] == subCounts[3]) matchingNums++;
            }
        }

        if (matchingNums == 4) count++;

        int left = 0;
        int right = p;

        while (right < s) {
            switch(dnaArr[left]) {
                case 'A':
                    if (minNums[0] == subCounts[0]) matchingNums--;
                    subCounts[0]--;
                    break;
                case 'C':
                    if (minNums[1] == subCounts[1]) matchingNums--;
                    subCounts[1]--;
                    break;
                case 'G':
                    if (minNums[2] == subCounts[2]) matchingNums--;
                    subCounts[2]--;
                    break;
                case 'T':
                    if (minNums[3] == subCounts[3]) matchingNums--;
                    subCounts[3]--;
            }

            switch (dnaArr[right]) {
                case 'A':
                    subCounts[0]++;
                    if (minNums[0] == subCounts[0]) matchingNums++;
                    break;
                case 'C':
                    subCounts[1]++;
                    if (minNums[1] == subCounts[1]) matchingNums++;
                    break;
                case 'G':
                    subCounts[2]++;
                    if (minNums[2] == subCounts[2]) matchingNums++;
                    break;
                case 'T':
                    subCounts[3]++;
                    if (minNums[3] == subCounts[3]) matchingNums++;
            }

            if (matchingNums == 4) count++;

            left++;
            right++;
        }

        System.out.println(count);
    }
}
