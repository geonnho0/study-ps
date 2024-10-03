import java.util.*;

class Solution {
    int[][] graph = new int[101][101];
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] r : rectangle)
            draw(r);
        
        return bfs(getPoint(characterX, characterY), getPoint(itemX, itemY));
    }
    
    int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        graph[start[0]][start[1]] = 0;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == end[0] && curr[1] == end[1])
                return curr[2] / 2;
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i], ny = curr[1] + dy[i];
                
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100)
                    continue;
                if (graph[nx][ny] != -2)
                    continue;
                graph[nx][ny] = curr[2] + 1;
                q.offer(new int[]{nx, ny, graph[nx][ny]});
            }
        }
        return -1;
    }
    
    int[] getPoint(int x, int y) {
        return new int[]{100 - 2 * y, 2 * x};
    }
    
    void draw(int[] rect) {
        int[] ld = getPoint(rect[0], rect[1]);
        int[] ru = getPoint(rect[2], rect[3]);
        for (int x = ru[0]; x <= ld[0]; x++)
            for (int y = ld[1]; y <= ru[1]; y++) {
                if (graph[x][y] == -1)
                    continue;
                graph[x][y] = -1;
                if (x == ru[0] || x == ld[0] || y == ld[1] || y == ru[1])
                    graph[x][y] = -2;                   
            }
    }
}