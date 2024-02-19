import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) continue;
                ans = Math.max(ans, bfs(i, j));
            }
        }
        System.out.println(ans);
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = curr.x + dx[i], nextY = curr.y + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (visited[nextX][nextY]) continue;
                if (graph[nextX][nextY] == 1)
                    return curr.distance + 1;
                visited[nextX][nextY] = true;
                queue.offer(new Node(nextX, nextY, curr.distance + 1));
            }
        }
        return 0;
    }

}

class Node {
    int x, y, distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}