class Solution {
    int[] parent;
    int n;
    int[][] wires;
    public int solution(int n, int[][] wires) {
        this.wires = wires;
        this.n = n;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int diff = findDiff(i);
            if (answer > diff)
                answer = diff;
        }
        return answer;
    }
    
    int findDiff(int exceptWireIndex) {
        init();
        
        for (int i = 0; i < wires.length; i++) {
            if (i == exceptWireIndex)
                continue;
            union(wires[i][0], wires[i][1]);
        }
        
        int[] count = new int[2];
        int firstRoot = parent[1];
        count[0] = 1;
        for (int i = 2; i <= n; i++) {
            if (findRoot(i) == firstRoot)
                count[0]++;
            else
                count[1]++;
        }
        int ret = count[1] - count[0];
        return ret > 0 ? ret : 0 - ret;
    }
    
    void init() {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
    }
    
    int findRoot(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findRoot(parent[x]);
    }
    
    void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA < rootB)
            parent[rootB] = rootA;
        else
            parent[rootA] = rootB;
    }
}