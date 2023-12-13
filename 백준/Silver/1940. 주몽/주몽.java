import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] materials = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        br.close();

        Map<Integer, Boolean> map = new HashMap<>();
        int count = 0;

        for (int material : materials) {
            boolean counted = false;

            if (map.containsKey(m - material)) {
                count++;
                map.put(m - material, false);
                counted = true;
            }

            map.put(material, counted);
        }

        System.out.println(count);
    }
}