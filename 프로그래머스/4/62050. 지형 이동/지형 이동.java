import java.util.*;

class Solution {
    int[][] land;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    int height, N, answer;
    PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    
    public int solution(int[][] land, int height) {
        init(land, height);
        pqueue.offer(new int[]{0, 0, 0});
        while (!pqueue.isEmpty()) {
            int[] next = pqueue.poll();
            if (visited[next[0]][next[1]])
                continue;
            answer += next[2];
            bfs(next);
        }
        return answer;
    }
    
    void init(int[][] land, int height) {
        N = land.length;
        this.land = land;
        visited = new boolean[N][N];
        this.height = height;
        answer = 0;
    }
    
    void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                    continue;
                if (visited[nextX][nextY])
                    continue;
                int sub = Math.abs(land[nextX][nextY] - land[curr[0]][curr[1]]);
                if (sub > height) {
                    pqueue.offer(new int[]{nextX, nextY, sub});
                    continue;
                }
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
            }
        }
    }
}