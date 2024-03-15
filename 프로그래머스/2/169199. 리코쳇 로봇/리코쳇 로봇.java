import java.util.*;

class Solution {
    int n, m;
    char[][] graph;
    int[] start = {0, 0}, target = {0, 0};
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public int solution(String[] board) {
        init(board);
        return bfs();
    }
    
    void init(String[] board) {
        n = board.length;
        m = board[0].length();
        graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] = board[i].charAt(j);
                if (graph[i][j] == 'G') {
                    target[0] = i;
                    target[1] = j;
                }
                if (graph[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
    }
    
    int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distances = new int[n][m];
        queue.offer(new int[]{start[0], start[1]});
        distances[start[0]][start[1]] = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                while (canForward(nextX, nextY)) {
                    nextX += dx[i];
                    nextY += dy[i];
                }
                nextX -= dx[i];
                nextY -= dy[i];
                if (nextX == target[0] && nextY == target[1]) {
                    return distances[curr[0]][curr[1]];
                }
                if (distances[nextX][nextY] != 0) {
                    continue;
                }
                distances[nextX][nextY] = distances[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return -1;
    }
    
    boolean canForward(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (graph[x][y] == 'D') {
            return false;
        }
        return true;
    }
}