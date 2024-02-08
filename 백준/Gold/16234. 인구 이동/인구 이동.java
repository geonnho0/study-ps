import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;
        boolean exist = false;
        do {
            ans++;
            exist = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if (bfs(new Location(i, j)))
                        exist = true;
                }
            }
        } while (exist);

        System.out.println(ans);
    }

    private static boolean bfs(Location location) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(location);
        visited[location.x][location.y] = true;
        ArrayList<Location> unionList = new ArrayList<>();
        unionList.add(location);

        while (!queue.isEmpty()) {
            Location curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;
                Location next = new Location(nextX, nextY);
                if (!isUnion(next, curr)) continue;
                visited[nextX][nextY] = true;
                unionList.add(next);
                queue.offer(next);
            }
        }

        if (unionList.size() == 1) {
            unionList.clear();
            return false;
        }

        int size = unionList.size();
        int sum = 0;
        for (Location l : unionList) {
            sum += graph[l.x][l.y];
        }
        sum /= size;
        for (Location l : unionList) {
            graph[l.x][l.y] = sum;
        }
        return true;
    }

    private static boolean isUnion(Location l1, Location l2) {
        int minus = Math.abs(graph[l1.x][l1.y] - graph[l2.x][l2.y]);
        return minus >= L && minus <= R;
    }

}

class Location {
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}