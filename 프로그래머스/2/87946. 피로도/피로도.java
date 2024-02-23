import java.util.*;

class Solution {
    
    boolean[] visited;
    int[][] dungeons;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        dfs(k, 0);
        return max;
    }
    
    private void dfs(int tired, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            if (visited[i] || dungeon[0] > tired) {
                continue;
            }
            visited[i] = true;
            dfs(tired - dungeon[1], count + 1);
            visited[i] = false;
        }
        max = Math.max(max, count);
    }
}