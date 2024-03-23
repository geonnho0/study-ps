import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] melted;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        graph = new int[N][M];
        melted = new boolean[N][M];
        int cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
                if (graph[i][j] == 1)
                    cheeseCount++;
            }
        }
        int time = 0;
        while (true) {
            time++;
            List<int[]> cheese = bfs();
            cheeseCount -= cheese.size();
            if (cheeseCount == 0) {
                System.out.println(time);
                System.out.print(cheese.size());
                break;
            }
            for (int[] c : cheese) {
                graph[c[0]][c[1]] = 0;
                melted[c[0]][c[1]] = true;
            }
        }
    }

    static List<int[]> bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        List<int[]> cheese = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;
                if (visited[nextX][nextY])
                    continue;
                if (graph[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                    continue;
                }
                visited[nextX][nextY] = true;
                cheese.add(new int[]{nextX, nextY});
            }
        }
        return cheese;
    }

}