import java.util.*;

class Solution {
    
    ArrayList<Integer>[] edges;
    int[] distances;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            edges[edge[i][0]].add(edge[i][1]);
            edges[edge[i][1]].add(edge[i][0]);
        }
        distances = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        bfs();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distances[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (max == distances[i]) {
                answer++;
            }
        }
        return answer;
    }
    
    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distances[1] = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next: edges[curr]) {
                if (distances[next] > distances[curr] + 1) {
                    distances[next] = distances[curr] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}