import java.io.*;
import java.util.*;

public class Main {

    static int[][] distances;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        graph = new char[R][C];
        distances = new int[R][C];
        int[] start = new int[2];
        Queue<int[]> water = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                graph[i][j] = line[j].charAt(0);
                if (graph[i][j] == 'S')
                    start = new int[]{i, j};
                if (graph[i][j] == '*') {
                    water.offer(new int[]{i, j});
                    distances[i][j] = 1;
                }
            }
        }
        spreadWater(water);
        bfs(start);
    }

    static void spreadWater(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
                    continue;
                if (graph[nextX][nextY] == 'X')
                    continue;
                if (graph[nextX][nextY] == '.' && distances[nextX][nextY] == 0) {
                    distances[nextX][nextY] = distances[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        distances[start[0]][start[1]] = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
                    continue;
                if (graph[nextX][nextY] == 'X' || graph[nextX][nextY] == '*')
                    continue;
                if (graph[nextX][nextY] == 'D') {
                    System.out.print(distances[curr[0]][curr[1]]);
                    return;
                }
                if (distances[nextX][nextY] == 0 || distances[nextX][nextY] > distances[curr[0]][curr[1]] + 1) {
                    distances[nextX][nextY] = distances[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        System.out.print("KAKTUS");
    }

}