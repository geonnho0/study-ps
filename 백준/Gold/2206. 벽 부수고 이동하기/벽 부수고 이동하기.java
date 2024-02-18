import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] line = st.nextToken().split("");
            for (int j = 0; j < M; j++)
                graph[i][j] = line[j].charAt(0) - '0';
        }
        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][][] visited = new boolean[N][M][2];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == N - 1 && curr.y == M - 1)
                return curr.distance;

            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i], nextY = curr.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

                if (graph[nextX][nextY] == 0) {
                    if (curr.broken && !visited[nextX][nextY][1]) {
                        visited[nextX][nextY][1] = true;
                        queue.offer(new Node(nextX, nextY, curr.distance + 1, true));
                    }
                    else if (!curr.broken && !visited[nextX][nextY][0]) {
                        visited[nextX][nextY][0] = true;
                        queue.offer(new Node(nextX, nextY, curr.distance + 1, false));
                    }
                }
                else {
                    if (!curr.broken && !visited[nextX][nextY][0]) {
                        visited[nextX][nextY][0] = true;
                        queue.offer(new Node(nextX, nextY, curr.distance + 1, true));
                    }
                }
            }
        }
        return -1;
    }
}

class Node {
    int x, y, distance;
    boolean broken;

    public Node(int x, int y, int distance, boolean broken) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.broken = broken;
    }
}