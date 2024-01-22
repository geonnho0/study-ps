import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int K = scanner.nextInt();

        ArrayList<Edge>[] arr = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            arr[u].add(new Edge(v, w));
        }

        int[] distances = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            if (i == K) distances[i] = 0;
            else distances[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(K, 0));

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();
            int end = curr.end;
            if (visited[end]) continue;
            visited[end] = true;

            for (Edge edge: arr[end]) {
                if (distances[edge.end] > distances[end] + edge.weight) {
                    distances[edge.end] = distances[end] + edge.weight;
                    queue.offer(new Edge(edge.end, distances[edge.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) System.out.println(distances[i]);
            else System.out.println("INF");
        }
    }

}

class Edge implements Comparable<Edge> {
    int end;
    int weight;

    public Edge(int end, int weight) {
        this.weight = weight;
        this.end = end;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}