import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Node>[] graph;
    static int[] distances;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distances = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distances[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(C, B));
            graph[B].add(new Node(C, A));
        }

        dijkstra();

        System.out.println(distances[N]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distances[1] = 0;
        queue.offer(new Node(0, 1));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (visited[curr.index]) continue;
            visited[curr.index] = true;

            for (Node next: graph[curr.index]) {
                int sum = curr.distance + next.distance;
                if (distances[next.index] < sum) continue;
                distances[next.index] = sum;
                queue.offer(new Node(distances[next.index], next.index));
            }
        }
    }

}

class Node implements Comparable<Node> {
    int distance, index;

    public Node(int distance, int index) {
        this.distance = distance;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}