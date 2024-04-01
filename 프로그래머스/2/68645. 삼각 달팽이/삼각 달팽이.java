import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] dp = new int[n][n];
        int x = -1, y = 0, num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0)
                    x += 1;
                else if (i % 3 == 1)
                    y += 1;
                else {
                    x -= 1;
                    y -= 1;
                }
                dp[x][y] = num++;
            }
        }
        
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (dp[i][j] != 0)
                    temp.add(dp[i][j]);
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = temp.get(i);
        return answer;
    }
}