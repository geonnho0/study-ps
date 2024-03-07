import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = line[j].charAt(0);
            }
        }
        int normal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normal++;
                    bfs(i, j, true);
                }
            }
        }
        int abnormal = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    abnormal++;
                    bfs(i, j, false);
                }
            }
        }
        System.out.print(normal + " " + abnormal);
    }

    static void bfs(int x, int y, boolean normal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        char color = graph[x][y];
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (normal) {
                    if (graph[nextX][nextY] == color) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
                else {
                    if (color == 'R' || color == 'G') {
                        if (graph[nextX][nextY] == 'R' || graph[nextX][nextY] == 'G') {
                            visited[nextX][nextY] = true;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                    else {
                        if (graph[nextX][nextY] == color) {
                            visited[nextX][nextY] = true;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
    }

}