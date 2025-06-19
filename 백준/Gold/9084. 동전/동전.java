import java.io.*;

public class Main {

    private static int solution(int n, int m, int[] coins) {
        int[][] dp = new int[m + 1][n];
        for (int i = 0; i < n; i++)
            if (m >= coins[i])
                dp[coins[i]][i] = 1;

        for (int i = 2; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] > 0)
                    for (int k = 0; k <= j; k++)
                        dp[i][j] += dp[i - coins[j]][k];
            }
        }

        int ans = 0;
        for (int k = 0; k < n; k++)
            ans += dp[m][k];
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                coins[i] = Integer.parseInt(line[i]);
            int m = Integer.parseInt(br.readLine());
            System.out.println(solution(n, m, coins));
        }
    }
}