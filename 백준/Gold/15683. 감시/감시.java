import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, ans = Integer.MAX_VALUE;
    static int[][] graph;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static List<int[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
                if (graph[i][j] > 0 && graph[i][j] < 6) {
                    cctv.add(new int[]{i, j, graph[i][j]});
                }
            }
        }
        dfs(0);
        System.out.print(ans);
    }

    static void check(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            int nextX = x + dx[dir], nextY = y + dy[dir];
            x = nextX;
            y = nextY;
            if (!valid(nextX, nextY)) {
                return;
            }
            if (graph[nextX][nextY] == 6) {
                return;
            }
            if (graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = -1;
            }
        }
    }

    static void dfs(int index) {
        if (index == cctv.size()) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 0) {
                        temp++;
                    }
                }
            }
            ans = Math.min(ans, temp);
            return;
        }

        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = graph[i][j];
            }
        }

        int[] curr = cctv.get(index);

        for (int dir = 0; dir < 4; dir++) {
            if (curr[2] == 1) {
                check(curr[0], curr[1], dir);
            }
            else if (curr[2] == 2) {
                check(curr[0], curr[1], dir);
                check(curr[0], curr[1], dir + 2);
            }
            else if (curr[2] == 3) {
                check(curr[0], curr[1], dir);
                check(curr[0], curr[1], dir + 1);
            }
            else if (curr[2] == 4) {
                check(curr[0], curr[1], dir);
                check(curr[0], curr[1], dir + 1);
                check(curr[0], curr[1], dir + 2);
            }
            else if (curr[2] == 5) {
                check(curr[0], curr[1], dir);
                check(curr[0], curr[1], dir + 1);
                check(curr[0], curr[1], dir + 2);
                check(curr[0], curr[1], dir + 3);
            }
            dfs(index + 1);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    graph[i][j] = temp[i][j];
                }
            }
        }
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}