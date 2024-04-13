import java.util.*;

class Solution {
    int[] parent;
    List<int[]> edges = new ArrayList<>();
    
    public int solution(int n, int[][] costs) {
        init(n, costs);
        int count = 0, answer = 0;
        while (count != n - 1) {
            for (int[] edge : edges) {
                if (find(edge[0]) == find(edge[1]))
                    continue;
                union(edge[0], edge[1]);
                answer += edge[2];
                count++;
                break;
            }
        }
        return answer;
    }
    
    void init(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int[] cost : costs) {
            int start = cost[0], end = cost[1], weight = cost[2];
            edges.add(new int[]{start, end, weight});
        }
        Collections.sort(edges, (e1, e2) -> e1[2] - e2[2]);
    }
    
    int find(int a) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }
    
    void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot)
            parent[bRoot] = parent[aRoot];
    }
}