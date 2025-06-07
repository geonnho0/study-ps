import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            bfs(i, computers, visited);
            answer++;
        }
        return answer;
    }
    
    void bfs(int x, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int next = 0; next < computers.length; next++) {
                if (computers[curr][next] == 0 || visited[next])
                    continue;
                
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}