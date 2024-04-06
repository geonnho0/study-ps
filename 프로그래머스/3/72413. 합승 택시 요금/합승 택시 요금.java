import java.util.*;

class Solution {
    
    int n;
    List<int[]>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(n, fares);
        int[][] distances = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            distances[i] = dijkstra(i);
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++)
            answer = Math.min(answer, distances[s][i] + distances[i][a] + distances[i][b]);
        return answer;
    }
    
    void init(int n, int[][] fares) {
        this.n = n;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] fare : fares) {
            int start = fare[0], end = fare[1], weight = fare[2];
            graph[start].add(new int[]{end, weight});
            graph[end].add(new int[]{start, weight});
        }
    }
    
    int[] dijkstra(int s) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.offer(new int[]{s, 0});
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[s] = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            if (curr[1] > distances[curr[0]])
                continue;
            
            for (int[] next : graph[curr[0]]) {
                if (distances[next[0]] > distances[curr[0]] + next[1]) {
                    distances[next[0]] = distances[curr[0]] + next[1];
                    queue.offer(new int[]{next[0], distances[next[0]]});
                }
            }
        }
        
        return distances;
    }
}