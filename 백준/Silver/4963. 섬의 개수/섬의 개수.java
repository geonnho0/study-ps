import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1}, dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] line = br.readLine().split(" ");
            int w = Integer.parseInt(line[0]), h = Integer.parseInt(line[1]);
            if (w == 0 && h == 0) {
                break;
            }
            graph = new int[h][w];
            for (int i = 0; i < h; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(line[j]);
                }
            }
            int count = 0;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j, visited, h, w);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y, boolean[][] visited, int h, int w) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];

                if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) {
                    continue;
                }
                if (graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

}