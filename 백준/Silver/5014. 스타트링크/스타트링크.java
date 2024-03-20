import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int F = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);
        int G = Integer.parseInt(line[2]);
        int U = Integer.parseInt(line[3]);
        int D = Integer.parseInt(line[4]);
        dp = new long[2000001];
        int ans = bfs(S, G, U, D, F);
        if (ans == -1)
            System.out.println("use the stairs");
        else
            System.out.println(ans);
    }

    static int bfs(int start, int target, int up, int down, int height) {
        int[] distances = new int[2000001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distances[start] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            int u = curr + up, d = curr - down;
            if (u <= height && distances[u] == 0) {
                distances[u] = distances[curr] + 1;
                queue.offer(u);
            }
            if (d > 0 && distances[d] == 0) {
                distances[d] = distances[curr] + 1;
                queue.offer(d);
            }
        }

        return distances[target] - 1;
    }

}