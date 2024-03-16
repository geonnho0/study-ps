import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);
        graph = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]), y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]) - 1, y2 = Integer.parseInt(line[3]) - 1;
            for (int x = y1; x <= y2; x++) {
                for (int y = x1; y <= x2; y++) {
                    graph[x][y] = 1;
                }
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || graph[i][j] == 1) {
                    continue;
                }
                count++;
                list.add(size(i, j));
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    static int size(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int size = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY] || graph[nextX][nextY] == 1) {
                    continue;
                }
                size++;
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return size;
    }

}