import java.util.*;

class Solution {
    
    int n;
    List<Integer>[] graph;
    int answer = 0;
    
    public int solution(int n, int[][] lighthouse) {
        init(n, lighthouse);
        dfs(1, 0);
        return answer;
    }
    
    void init(int n, int[][] lighthouse) {
        this.n = n;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] lh : lighthouse) {
            int start = lh[0], end = lh[1];
            graph[start].add(end);
            graph[end].add(start);
        }
    }
    
    int dfs(int curr, int parent) {
        if (graph[curr].size() == 1 && graph[curr].get(0) == parent)
            return 1;
        
        int temp = 0;
        for (int next : graph[curr]) {
            if (next != parent)
                temp += dfs(next, curr);
        }
        
        if (temp == 0)
            return 1;
        
        answer++;
        return 0;
    }
    
}