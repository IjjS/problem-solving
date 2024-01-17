import java.io.*;
import java.util.*;

public class Main {

    static List<Edge>[] graph;
    static int[] items;
    static int[] dist;
    static int n;
    static int m;

    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        items = new int[n + 1];
        dist = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, l));
            graph[b].add(new Edge(a, l));
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }

    static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (dist[curr.node] < curr.cost) continue;
            dist[curr.node] = curr.cost;

            for (Edge next : graph[curr.node]) {
                if (dist[next.node] > dist[curr.node] + next.cost) {
                    dist[next.node] = dist[curr.node] + next.cost;
                    pq.offer(new Edge(next.node, dist[next.node]));
                }
            }
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) sum += items[i];
        }

        return sum;
    }
}
