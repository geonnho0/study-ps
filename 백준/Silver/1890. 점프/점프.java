import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!(i == 0 && j == 0) && dp[i][j] == 0) {
                    continue;
                }
                if (board[i][j] == 0) {
                    continue;
                }
                if (i + board[i][j] < N) {
                    dp[i + board[i][j]][j] += dp[i][j];
                }
                if (j + board[i][j] < N) {
                    dp[i][j + board[i][j]] += dp[i][j];
                }
            }
        }
        System.out.print(dp[N - 1][N - 1]);
    }

}