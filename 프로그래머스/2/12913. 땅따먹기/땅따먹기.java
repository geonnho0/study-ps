import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                dp[i][j] = land[i][j];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] += findMax(dp, i, j);
            }
        }
        
        int answer = 0;
        for (int j = 0; j < 4; j++)
            answer = Math.max(answer, dp[n - 1][j]);
        return answer;
    }
    
    int findMax(int[][] l, int i, int j) {
        int res = 0;
        for (int ii = 0; ii < 4; ii++) {
            if (ii == j)
                continue;
            res = Math.max(res, l[i - 1][ii]);
        }
        return res;
    }
}