import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] strings = scanner.nextLine().split("");
            for (int j = 0; j < m; j++)
                dp[i][j + 1] = Integer.parseInt(strings[j]);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == 0) continue;
                int min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.min(min, dp[i][j - 1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max * max);
    }

}