import java.util.*;

class Solution {
    List<Integer>[] edges;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();
        
        for (int[] r : roads) {
            edges[r[0]].add(r[1]);
            edges[r[1]].add(r[0]);
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            if (sources[i] == destination) {
                answer[i] = 0;
                continue;
            }
            answer[i] = findShortest(sources[i], destination, n);
        }
        
        return answer;
    }
    
    int findShortest(int start, int dest, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int[] dist = new int[n + 1];
        dist[start] = 1;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            
            for (int next : edges[curr]) {
                if (dist[next] != 0)
                    continue;
                if (next == dest)
                    return dist[curr];
                
                dist[next] = dist[curr] + 1;
                q.offer(next);
            }
        }
        return -1;
    }
}
