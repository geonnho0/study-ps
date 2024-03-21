import java.util.*;

class Solution {
    
    int[][] cost = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };
    
    int[][][] dp;
    String numbers;
    int N;
    
    public int solution(String numbers) {
        init(numbers);
        return dfs(0, 4, 6);
    }
    
    void init(String numbers) {
        this.numbers = numbers;
        N = numbers.length();
        dp = new int[N + 1][10][10];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 10; j++)
                Arrays.fill(dp[i][j], -1);
        }
    }
    
    int dfs(int index, int L, int R) {
        if (index == N)
            return 0;
        if (dp[index][L][R] != -1)
            return dp[index][L][R];
        
        int num = numbers.charAt(index) - '0';
        int res = Integer.MAX_VALUE;
        
        if (num != R)
            res = Math.min(dfs(index + 1, num, R) + cost[L][num], res);
        if (num != L)
            res = Math.min(dfs(index + 1, L, num) + cost[R][num], res);
        
        return dp[index][L][R] = res;
    }
    
}