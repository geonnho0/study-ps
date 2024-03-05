import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Edge>[] graph;
    static long[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        graph = new ArrayList[N + 1];
        distances = new long[N + 1];
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

    static void dijkstra(int start, int N) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        queue.offer(new Edge(start, 0));
        distances[start] = 0;

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();

            for (Edge e : graph[curr.end]) {
                if (distances[e.end] > curr.weight + e.weight) {
                    distances[e.end] = Math.min(distances[e.end], curr.weight + e.weight);
                    queue.offer(new Edge(e.end, distances[e.end]));
                }
            }
        }
    }

    static void getAnswer(int[] target, int N) {
        dijkstra(target[0], N);
        long target1To1 = distances[1];
        long target1ToTarget2 = distances[target[1]];
        long target1ToN = distances[N];

        dijkstra(target[1], N);
        long target2To1 = distances[1];
        long target2ToN = distances[N];

        long first = target1To1 + target1ToTarget2 + target2ToN;
        long second = target2To1 + target1ToTarget2 + target1ToN;

        long min = Math.min(first, second);

        System.out.print(min >= Integer.MAX_VALUE ? "-1" : min);
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