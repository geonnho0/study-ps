import java.util.*;

class Solution {
    
    int N, M;
    int[][] graph;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    List<Integer> count = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        init(maps);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                count.add(bfs(i, j));
            }
        }
        if (count.size() == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[count.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count.get(i);
        } 
        Arrays.sort(answer);
        return answer;
    }
    
    public void init(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] map = maps[i].split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = map[j].equals("X") ? 0 : Integer.parseInt(map[j]);
            }
        }
    }
    
    public int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int count = graph[x][y];
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i], nextY = curr[1] + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                if (graph[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }
                count += graph[nextX][nextY];
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return count;
    }
    
}