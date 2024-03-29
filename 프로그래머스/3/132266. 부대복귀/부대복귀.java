import java.util.*;

class Solution {
    
    int n, dest;
    int[] answer;
    List<Integer>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        init(n, roads, sources, destination);
        for (int i = 0; i < sources.length; i++)
            answer[i] = bfs(sources[i]);
        return answer;
    }
    
    void init(int n, int[][] roads, int[] sources, int dest) {
        this.n = n;
        this.dest = dest;
        answer = new int[sources.length];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
    }
    
    int bfs(int start) {
        if (start == dest)
            return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] dist = new int[n + 1];
        dist[start] = 1;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next : graph[curr]) {
                if (dist[next] != 0)
                    continue;
                dist[next] = dist[curr] + 1;
                if (next == dest)
                    return dist[next] - 1;
                queue.offer(next);
            }
        }
        
        return -1;
    }
}