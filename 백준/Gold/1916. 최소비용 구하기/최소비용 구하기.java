import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        ArrayList<Edge>[] arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            arr[u].add(new Edge(v, w));
        }

        int startCity = scanner.nextInt();
        int endCity = scanner.nextInt();

        int[] distances = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == startCity) distances[i] = 0;
            else distances[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(startCity, 0));

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();
            int end = curr.end;
            if (visited[end]) continue;
            visited[end] = true;

            for (Edge edge: arr[end]) {
                distances[edge.end] = Math.min(distances[edge.end], distances[end] + edge.weight);
                queue.offer(new Edge(edge.end, distances[edge.end]));
            }
        }

        System.out.println(distances[endCity]);
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