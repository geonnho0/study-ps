import java.util.*;

class Solution {
    List<Integer>[] edges;
    int n;
    public int solution(int n, int[][] edge) {
        this.n = n;
        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();
        for (int[] e : edge) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        return bfs(1);
    }
    
    int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int[] dist = new int[n + 1];
        dist[start] = 1;
        
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            
            for (Integer next : edges[curr]) {
                if (dist[next] == 0) {
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        for (int d : dist)
            if (d > max)
                max = d;
        int count = 0;
        for (int d : dist)
            if (d == max)
                count++;
        return count;
    }
}