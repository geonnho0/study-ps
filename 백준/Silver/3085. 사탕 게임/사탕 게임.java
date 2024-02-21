import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[][] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new String[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] line = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = line[j];
            }
        }

        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nextX = i + dx[k], nextY = j + dy[k];
                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                    max = Math.max(max, changeAndCheck(i, j, nextX, nextY));
                    if (max == N) {
                        System.out.println(max);
                        return;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static int changeAndCheck(int x1, int y1, int x2, int y2) {
        String temp = graph[x1][y1];
        graph[x1][y1] = graph[x2][y2];
        graph[x2][y2] = temp;
        int res = check(x1, y1, true);
        res = Math.max(res, check(x1, y1, false));
        res = Math.max(res, check(x2, y2, true));
        res = Math.max(res, check(x2, y2, false));
        graph[x2][y2] = graph[x1][y1];
        graph[x1][y1] = temp;
        return res;
    }

    static int check(int x, int y, boolean isX) {
        String curr = graph[x][y];
        int ans = 0;
        if (isX) {
            int index = x - 1;
            while (index >= 0 && graph[index][y].equals(curr)) {
                index--;
                ans++;
            }
            index = x + 1;
            while (index < N && graph[index][y].equals(curr)) {
                index++;
                ans++;
            }
        }
        else {
            int index = y - 1;
            while (index >= 0 && graph[x][index].equals(curr)) {
                index--;
                ans++;
            }
            index = y + 1;
            while (index < N && graph[x][index].equals(curr)) {
                index++;
                ans++;
            }
        }
        return ans + 1;
    }

}