import java.util.*;

class Solution {
    
    int[][] graph;
    int n;
    
    public int solution(int n, int[][] results) {
        init(n, results);
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] == 0 && graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1)
                    count++;
            }
            if (count == n - 1)
                answer++;
        }
        return answer;
    }
    
    void init(int n, int[][] res) {
        this.n = n;
        graph = new int[n + 1][n + 1];
        for (int[] r : res) {
            int start = r[0], end = r[1];
            graph[start][end] = 1;
        }
    }
    
}