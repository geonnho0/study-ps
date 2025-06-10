class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for (int[] r : results) {
            graph[r[0]][r[1]] = 1;
            graph[r[1]][r[0]] = -1;
        }
        floyd(graph);
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int result : graph[i])
                if (result != 0)
                    count++;
            
            if (count == n - 1)
                answer++;
        }
        return answer;
    }
    
    public void floyd(int[][] graph) {
        int n = graph.length;
        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (graph[i][j] != 0)
                        continue;
                    
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
    }
}
