import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    dp[i][j] = dp[i][j - 1] + elements[j - 1];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i > j) {
                    dp[i][j] = dp[i][n] + dp[1][j];
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                set.add(dp[i][j]);
            }
        }
        return set.size();
    }
}