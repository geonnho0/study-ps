import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[] filter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        int T = Integer.parseInt(line[2]);
        graph = new int[R][C];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
                if (graph[i][j] == -1) {
                    filter = new int[]{i, j};
                }
                if (graph[i][j] > 0) {
                    queue.offer(new int[]{i, j, graph[i][j]});
                }
            }
        }
        while (T-- > 0) {
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                spread(curr[0], curr[1], curr[2]);
            }
            doFilter();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (graph[i][j] > 0) {
                        queue.offer(new int[]{i, j, graph[i][j]});
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += graph[i][j];
            }
        }
        System.out.print(sum + 2);
    }

    static void spread(int x, int y, int value) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            if (!valid(nextX, nextY)) {
                continue;
            }
            if (graph[nextX][nextY] == -1) {
                continue;
            }
            graph[nextX][nextY] += value / 5;
            graph[x][y] -= value / 5;
        }
    }

    static void doFilter() {
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int x = filter[0] - 1, y = filter[1];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            while (valid(nextX, nextY) && nextX <= filter[0] - 1) {
                if (x == filter[0] - 1 && y == filter[1]) {
                    graph[nextX][nextY] = 0;
                }
                else if (nextX == filter[0] - 1 && nextY == filter[1]) {
                    graph[x][y] = 0;
                }
                else {
                    graph[x][y] = graph[nextX][nextY];
                }
                x = nextX;
                y = nextY;
                nextX = x + dx[i];
                nextY = y + dy[i];
            }
        }
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        x = filter[0];
        y = filter[1];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            while (valid(nextX, nextY) && nextX >= filter[0]) {
                if (x == filter[0] && y == filter[1]) {
                    graph[nextX][nextY] = 0;
                }
                else if (nextX == filter[0] && nextY == filter[1]) {
                    graph[x][y] = 0;
                }
                else {
                    graph[x][y] = graph[nextX][nextY];
                }
                x = nextX;
                y = nextY;
                nextX = x + dx[i];
                nextY = y + dy[i];
            }
        }
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}