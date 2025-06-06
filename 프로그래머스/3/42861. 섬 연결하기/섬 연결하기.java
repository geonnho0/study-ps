import java.util.*;

class Solution {
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        init(n);
        Arrays.sort(costs, (e1, e2) -> e1[2] - e2[2]);
        int answer = 0;
        int count = 0;
        for (int[] cost : costs) {
            if (count == n - 1)
                break;
            if (find(cost[0]) == find(cost[1]))
                continue;
            merge(cost[0], cost[1]);
            answer += cost[2];
            count += 1;
        }
        return answer;
    }
    
    void init(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;
    }
    
    int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }
    
    void merge(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parents[rootB] = rootA;
    }
}