import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        M = Integer.parseInt(line[2]);
        graph = new List[N + M + 1];
        for (int i = 1; i <= N + M; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = N + 1; i <= N + M; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                int curr = Integer.valueOf(line[j]);
                graph[curr].add(i);
                graph[i].add(curr);
            }
        }
        System.out.print(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[N + M + 1];
        for (int i = 1; i <= N + M; i++) {
            distances[i] = -1;
        }
        queue.offer(1);
        distances[1] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph[curr]) {
                if (distances[next] != -1) {
                    continue;
                }
                distances[next] = distances[curr] + (next > N ? 0 : 1);
                queue.offer(next);
            }
        }

        return distances[N];
    }

}