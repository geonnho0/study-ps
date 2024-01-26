import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            long[][] dp = new long[n + 1][m + 1];
            for (int i = 1; i <= m; i++) dp[1][i] = i;

            for (int i = 2; i <= n; i++)
                for (int j = i; j <= m; j++)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];

            System.out.println(dp[n][m]);
        }
    }

}