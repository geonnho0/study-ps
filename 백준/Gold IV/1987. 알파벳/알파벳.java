import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C, max;
    static char[][] graph;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String[] line = st.nextToken().split("");
            for (int j = 0; j < C; j++) {
                graph[i][j] = line[j].charAt(0);
            }
        }

        setVisited(0, 0, true);
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int depth) {
        max = Math.max(max, depth);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
            if (getVisited(nextX, nextY)) continue;
            setVisited(nextX, nextY, true);
            dfs(nextX, nextY, depth + 1);
        }

        setVisited(x, y, false);
    }

    static boolean getVisited(int x, int y) {
        int index = graph[x][y] - 'A';
        return visited[index];
    }

    static void setVisited(int x, int y, boolean value) {
        int index = graph[x][y] - 'A';
        visited[index] = value;
    }

}