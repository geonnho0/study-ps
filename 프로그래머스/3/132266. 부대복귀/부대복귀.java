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
        
        int[] dist = findShortest(destination, n);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++)
            answer[i] = dist[sources[i]];
        
        return answer;
    }
    
    int[] findShortest(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int next : edges[curr]) {
                if (dist[next] != -1)
                    continue;
                
                dist[next] = dist[curr] + 1;
                q.offer(next);
            }
        }
        return dist;
    }
}
