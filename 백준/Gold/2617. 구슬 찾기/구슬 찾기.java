import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] more, less;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        graph = new ArrayList[N + 1];
        more = new int[N + 1];
        less = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (more[i] > (N - 1) / 2 || less[i] > (N - 1) / 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next: graph[curr]) {
                if (visited[next]) {
                    continue;
                }
                more[start]++;
                visited[next] = true;
                less[next]++;
                queue.offer(next);
            }
        }
    }

}