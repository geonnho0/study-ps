import java.util.*;

class Solution {
    int answer = 0;
    List<Integer>[] graph;
    int[] info;
    boolean[][][] visited;
    public int solution(int[] info, int[][] edges) {
        init(info, edges);
        visited[0][1][0] = true;
        info[0] = -1;
        dfs(0, 1, 0);
        return answer;
    }
    
    void init(int[] info, int[][] edges) {
        this.info = info;
        graph = new ArrayList[info.length];
        visited = new boolean[info.length][20][20];
        for (int i = 0; i < info.length; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }
    
    void dfs(int index, int sheep, int wolf) {
        if (index == 0)
            answer = Math.max(answer, sheep);
        
        for (int next : graph[index]) {
            if (info[next] == -1) {
                if (visited[next][sheep][wolf])
                    continue;
                visited[next][sheep][wolf] = true;
                dfs(next, sheep, wolf);
                visited[next][sheep][wolf] = false;
            }
            else {
                boolean isWolf = info[next] == 1;
                int nextSheep = sheep + (isWolf ? 0 : 1), nextWolf = wolf + (isWolf ? 1 : 0);
                if (visited[next][nextSheep][nextWolf])
                    continue;
                if (isWolf && sheep <= wolf + 1)
                    continue;
                info[next] = -1;
                visited[next][nextSheep][nextWolf] = true;
                dfs(next, nextSheep, nextWolf);
                info[next] = isWolf ? 1 : 0;
                visited[next][nextSheep][nextWolf] = false;
            }
            
        }
    }
}