import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] graph;
    static int[][] count;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        graph = new int[N + 1][M + 1];
        count = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            line = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(line[j - 1]);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                count[i][j] = -1;
            }
        }
        dfs(N, M);
        System.out.print(count[N][M]);
    }

    static int dfs(int x, int y) {
        if (x == 1 && y == 1) {
            return 1;
        }
        if (count[x][y] == -1) {
            count[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i], nextY = y + dy[i];
                if (nextX < 1 || nextX > N || nextY < 1 || nextY > M) {
                    continue;
                }
                if (graph[nextX][nextY] > graph[x][y]) {
                    count[x][y] += dfs(nextX, nextY);
                }
            }
        }
        return count[x][y];
    }

}