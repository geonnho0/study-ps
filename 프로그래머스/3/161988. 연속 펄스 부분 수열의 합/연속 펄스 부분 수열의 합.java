import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long[][] dp = new long[sequence.length + 1][2];
        dp[1][0] = -sequence[0];
        dp[1][1] = sequence[0];
        for (int i = 2; i <= sequence.length; i++) {
            long temp = dp[i - 1][1] + (0 - sequence[i - 1]);
            dp[i][0] = temp < (0 - sequence[i - 1]) ? (0 - sequence[i - 1]) : temp;
            temp = dp[i - 1][0] + sequence[i - 1];
            dp[i][1] = temp < sequence[i - 1] ? sequence[i - 1] : temp;
        }
        long max = 0;
        for (int i = 1; i <= sequence.length; i++) {
            max = Math.max(dp[i][0], max);
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}