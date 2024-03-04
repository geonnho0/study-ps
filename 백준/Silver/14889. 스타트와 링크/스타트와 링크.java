import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(line[j]);
            }
        }
        dfs(0, 0);
        System.out.print(min);
    }

    static void dfs(int index, int depth) {
        if (depth == (N / 2)) {
            min = Math.min(min, getDiff());
            return;
        }

        for (int i = index; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            int before = getDiff();
            visited[i] = true;
            int after = getDiff();
            if (before >= after) {
                dfs(i + 1, depth + 1);
            }
            visited[i] = false;
        }
    }

    static int getDiff() {
        int start = 0, link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += (S[i][j] + S[j][i]);
                }
                else if (!visited[i] && !visited[j]) {
                    link += (S[i][j] + S[j][i]);
                }
            }
        }
        return Math.abs(start - link);
    }

}