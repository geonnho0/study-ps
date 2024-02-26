import java.util.*;

class Solution {
    
    boolean pulled = false;
    char[][] maps;
    int[][] distances;
    int N = 0, M = 0;
    
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        this.maps = new char[N][M];
        int[] start = new int[2], end = new int[2], pull = new int[2];
        for (int i = 0; i < maps.length; i++) {
            String[] line = maps[i].split("");
            for (int j = 0; j < line.length; j++) {
                char c = line[j].charAt(0);
                this.maps[i][j] = line[j].charAt(0);
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                else if (c == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
                else if (c == 'L') {
                    pull[0] = i;
                    pull[1] = j;
                }
            }
        }
        distances = new int[N][M];
        int dist = bfs(start[0], start[1], pull[0], pull[1], 0);
        if (dist == -1) {
            return dist;
        }
        distances = new int[N][M];
        int answer = bfs(pull[0], pull[1], end[0], end[1], dist);
        return answer;
    }
    
    private int bfs(int x, int y, int dstX, int dstY, int distance) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        distances[x][y] = distance;
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i], nextY = curr.y + dy[i];
                
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                if (maps[nextX][nextY] == 'X') {
                    continue;
                }
                if (distances[nextX][nextY] != 0) {
                    continue;
                }
                distances[nextX][nextY] = distances[curr.x][curr.y] + 1;
                if (nextX == dstX && nextY == dstY) {
                    return distances[nextX][nextY];
                }
                queue.offer(new Node(nextX, nextY));
            }
        }
        return -1;
    }
}

class Node {
    int x, y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}