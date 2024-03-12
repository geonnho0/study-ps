import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(line[j - 1]);
            }
        }
        int[][][] dp = new int[N + 1][N + 1][4];
        dp[1][2][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (graph[i][j] == 1) {
                    continue;
                }
                if (j + 1 <= N && graph[i][j + 1] != 1) {
                    dp[i][j + 1][1] = dp[i][j][1] + dp[i][j][3];
                }
                if (i + 1 <= N && graph[i + 1][j] != 1) {
                    dp[i + 1][j][2] = dp[i][j][2] + dp[i][j][3];
                }
                if (i + 1 <= N && j + 1 <= N && graph[i + 1][j] != 1 && graph[i][j + 1] != 1 && graph[i + 1][j + 1] != 1) {
                    dp[i + 1][j + 1][3] = dp[i][j][1] + dp[i][j][2] + dp[i][j][3];
                }
            }
        }
        System.out.print(dp[N][N][1] + dp[N][N][2] + dp[N][N][3]);
    }

}