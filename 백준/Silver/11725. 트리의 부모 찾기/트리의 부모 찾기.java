import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] parents = new int[N + 1];
        bfs(N, graph, parents);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++)
            sb.append(parents[i]).append("\n");
        System.out.print(sb);
    }

    static void bfs(int N, List<Integer>[] graph, int[] parents) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph[curr]) {
                if (visited[next]) continue;
                visited[next] = true;
                parents[next] = curr;
                queue.offer(next);
            }
        }
    }

}