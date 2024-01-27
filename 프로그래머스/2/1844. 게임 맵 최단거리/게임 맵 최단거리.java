import java.util.*;

class Solution {
    
    private int n;
    private int m;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        int[][] answer = bfs(maps);
        if (answer[n - 1][m - 1] <= 1) return -1;
        return answer[n - 1][m - 1];
    }
    
    private int[][] bfs(int[][] maps) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0, 0));
        
        while (!queue.isEmpty()) {
            Location curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];
                
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (maps[nextX][nextY] != 1) continue;
                
                maps[nextX][nextY] = maps[curr.x][curr.y] + 1;
                queue.offer(new Location(nextX, nextY));
            }
        }
        
        return maps;
    }
    
}

class Location {
    int x;
    int y;
    
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}