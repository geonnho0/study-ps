class Solution {
    
    private int n;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        visited = new boolean[n + 1];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int node, int[][] computers) {
        visited[node] = true;
        
        for (int i = 0; i < n; i++) {
            if (i == node) continue;
            if (computers[node][i] == 0 || visited[i]) continue;
            dfs(i, computers);
        }
    }
}