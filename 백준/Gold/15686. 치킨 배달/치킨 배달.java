import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] graph;
    static int[][] chicken;
    static boolean[] selected;
    static int N, M, chickenCount = 0, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        graph = new int[N][N];
        chicken = new int[15][2];
        for (int i = 0; i < 15; i++) {
            chicken[i] = new int[]{-1, -1};
        }
        selected = new boolean[15];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
                if (graph[i][j] == 2) {
                    chicken[chickenCount++] = new int[]{i, j};
                }
            }
        }

        dfs(0, 0);
        System.out.print(ans);
    }

    static void dfs(int index, int depth) {
        if (depth == M) {
            ans = Math.min(ans, getAns());
            return;
        }

        for (int i = index; i < chickenCount; i++) {
            if (selected[i]) {
                continue;
            }
            if (chicken[i][0] == -1) {
                return;
            }
            selected[i] = true;
            dfs(i + 1, depth + 1);
            selected[i] = false;
        }
    }

    static int getAns() {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = graph[i][j];
            }
        }

        for (int i = 0; i < chickenCount; i++) {
            if (selected[i] || chicken[i][0] == -1) {
                continue;
            }
            graph[chicken[i][0]][chicken[i][1]] = 0;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    ans += findShortestChicken(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = temp[i][j];
            }
        }

        return ans;
    }

    static int findShortestChicken(int x, int y) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < chickenCount; i++) {
            if (!selected[i]) {
                continue;
            }
            ans = Math.min(ans, Math.abs(x - chicken[i][0]) + Math.abs(y - chicken[i][1]));
        }
        return  ans;
    }

}