import java.util.*;

class Solution {
    
    List<int[]> answer = new ArrayList<>();
    
    public int[][] solution(int n) {
        dfs(1, 3, 2, n);
        int[][] answer = new int[this.answer.size()][2];
        for (int i = 0; i < this.answer.size(); i++)
            answer[i] = this.answer.get(i);
        return answer;
    }
    
    void dfs(int start, int end, int sub, int n) {
        if (n == 1) {
            move(start, end);
            return;
        }
        dfs(start, sub, end, n - 1);
        move(start, end);
        dfs(sub, end, start, n - 1);
    }
    
    void move(int start, int end) {
        answer.add(new int[]{start, end});
    }
}