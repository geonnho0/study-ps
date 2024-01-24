import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] dp = new long[N + 5][10];
        for (int i = 1; i <= 9; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            dp[i][9] = dp[i - 1][8] % 1000000000;
            for (int j = 1; j <= 8; j++)
                dp[i][j] = dp[i - 1][j + 1] % 1000000000 + dp[i - 1][j - 1] % 1000000000;
        }
        long res = 0;
        for (int i = 0; i <= 9; i++)
            res += dp[N][i];
        System.out.println(res % 1000000000);
    }

}