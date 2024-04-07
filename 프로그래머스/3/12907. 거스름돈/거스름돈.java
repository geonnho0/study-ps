import java.util.*;

class Solution {
    final int MOD = 1000000007;
    
    public int solution(int n, int[] money) {
        int m = money.length;
        int[][] dp = new int[n + 1][m + 1];
        Arrays.sort(money);
        for (int i = 0; i < m; i++)
            dp[money[i]][i + 1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] += dp[i][j - 1];
                int left = i - money[j - 1];
                if (left < 0)
                    continue;
                dp[i][j] = (dp[i][j] + dp[left][j]) % MOD;
            }
        }
        return dp[n][m] % MOD;
    }
}