import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n + 5][n + 5];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                cost[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[][] dp = new int[n + 5][n + 5];
        dp[0][0] = cost[0][0];
        dp[1][0] = dp[0][0] + cost[1][0];
        dp[1][1] = dp[0][0] + cost[1][1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
            dp[i][i] = dp[i - 1][i - 1] + cost[i][i];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + cost[i][j];
            }
        }
        int max = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }
        System.out.print(max);
    }

}