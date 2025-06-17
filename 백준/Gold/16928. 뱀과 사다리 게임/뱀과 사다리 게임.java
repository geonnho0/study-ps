import java.io.*;
import java.util.*;

public class Main {

    private static int solution(int N, int M, int[][] ladders, int[][] snakes) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        dist[1] = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] l : ladders)
            map.put(l[0], l[1]);
        for (int[] s : snakes)
            map.put(s[0], s[1]);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = curr + i;

                if (dist[next] != -1) continue;

                dist[next] = dist[curr] + 1;

                if (next == 100)
                    return dist[next];

                int destination = map.getOrDefault(next, -1);

                if (destination == -1) {
                    q.offer(next);
                    continue;
                }

                if (dist[destination] == -1 || dist[destination] > dist[curr] + 1) {
                    dist[destination] = dist[curr] + 1;
                    q.offer(destination);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] ladders = new int[n][2];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            ladders[i][0] = Integer.parseInt(line[0]);
            ladders[i][1] = Integer.parseInt(line[1]);
        }

        int[][] snakes = new int[m][2];
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            snakes[i][0] = Integer.parseInt(line[0]);
            snakes[i][1] = Integer.parseInt(line[1]);
        }

        System.out.println(solution(n, m, ladders, snakes));
    }
}