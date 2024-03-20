import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int len = wires.length;
        for (int i = 0; i < len; i++) {
            init(n);
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                union(wires[j][0], wires[j][1]);
            }
            
            int count1 = 1, count2 = 0;
            int temp = find(1);
            for (int j = 2; j <= n; j++) {
                if (temp == find(j))
                    count1++;
                else
                    count2++;
            }
            answer = Math.min(answer, Math.abs(count1 - count2));
        }
        
        return answer;
    }
    
    void init(int n) {
        parent = new int[n + 1];
        for (int i = 1; i < n; i++)
            parent[i] = i;
    }
    
    int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
    
    void union(int a, int b) {
        int aRoot = find(a), bRoot = find(b);
        if (aRoot == bRoot)
            return;
        parent[bRoot] = aRoot; 
    }
    
}