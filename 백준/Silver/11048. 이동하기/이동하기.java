import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[][] dp = new int[N][M];
        dp[0][0] = graph[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + graph[i + 1][j]);
                }
                if (j + 1 < M) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + graph[i][j + 1]);
                }
                if (i + 1 < N && j + 1 < M) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + graph[i + 1][j + 1]);
                }
            }
        }
        System.out.print(dp[N - 1][M - 1]);
    }

}