import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        String[] line = br.readLine().split(" ");
        int r = Integer.parseInt(line[0]), c = Integer.parseInt(line[1]);
        System.out.print(bfs(r, c));
    }

    static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        int[][] distances = new int[5][5];
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        distances[r][c] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) {
                    continue;
                }
                if (graph[nextX][nextY] == -1 || distances[nextX][nextY] != 0) {
                    continue;
                }
                distances[nextX][nextY] = distances[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{nextX, nextY});
                if (graph[nextX][nextY] == 1) {
                    return distances[nextX][nextY] - 1;
                }
            }
        }
        return -1;
    }

}