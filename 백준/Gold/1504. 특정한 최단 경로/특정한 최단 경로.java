import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]), c = Integer.parseInt(line[2]);
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        line = br.readLine().split(" ");
        int[] target = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
        getAnswer(target, N);
    }

    static long[] dijkstra(int start, long dist, int N) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        long[] distances = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[N + 1];
        queue.offer(new Edge(start, dist));
        distances[start] = dist;

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();
            int end = curr.end;
            if (visited[end]) {
                continue;
            }
            visited[end] = true;

            for (Edge e : graph[end]) {
                distances[e.end] = Math.min(distances[e.end], distances[end] + e.weight);
                queue.offer(new Edge(e.end, distances[e.end]));
            }
        }
        return distances;
    }

    static void getAnswer(int[] target, int N) {
        long first = dijkstra(1, 0, N)[target[0]];
        if (first == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }
        long second = dijkstra(target[0], first, N)[target[1]];
        if (second == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }
        long min = dijkstra(target[1], second, N)[N];
        if (min == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }
        first = dijkstra(1, 0, N)[target[1]];
        if (first == 800000) {
            System.out.println("-1");
            return;
        }
        second = dijkstra(target[1], first, N)[target[0]];
        if (second == 800000) {
            System.out.println("-1");
            return;
        }
        long temp = dijkstra(target[0], second, N)[N];
        if (temp == 800000) {
            System.out.println("-1");
            return;
        }
        min = Math.min(min, temp);
        System.out.println(min);
    }

}

class Edge implements Comparable<Edge> {
    int end;
    long weight;

    public Edge(int end, long weight) {
        this.weight = weight;
        this.end = end;
    }

    @Override
    public int compareTo(Edge o) {
        return (int) (this.weight - o.weight);
    }
}