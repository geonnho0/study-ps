import java.io.*;

public class Main {

    private static int solution(int n, int m, int[][] candies) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            dp[i][1] = dp[i - 1][1] + candies[i - 1][0];
        for (int j = 1; j <= m; j++)
            dp[1][j] = dp[1][j - 1] + candies[0][j - 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1])) + candies[i - 1][j - 1];

        return dp[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] candies = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                candies[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(solution(n, m, candies));
    }
}