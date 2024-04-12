import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int end = j + i;
                if (end >= n)
                    break;
                
                for (int k = j; k < end; k++)
                    dp[j][end] = Math.min(dp[j][end], dp[j][k] + dp[k + 1][end] + (matrix_sizes[j][0] * matrix_sizes[k + 1][0] * matrix_sizes[end][1]));
            }
        }
        
        return dp[0][n - 1];
    }
}