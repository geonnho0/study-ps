import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    long[] sum;
    int n;
    long answer = 0;
    
    public long solution(int[] a, int[][] edges) {
        n = a.length;
        graph = new ArrayList[n];
        sum = new long[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            sum[i] = a[i];
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        dfs(0, 0);
        if (sum[0] == 0)
            return answer;
        return -1;
    }
    
    void dfs(int curr, int parent) {
        for (int i = 0; i < graph[curr].size(); i++) {
            if (graph[curr].get(i) != parent)
                dfs(graph[curr].get(i), curr);
        }
        sum[parent] += sum[curr];
        answer += Math.abs(sum[curr]);
    }
}