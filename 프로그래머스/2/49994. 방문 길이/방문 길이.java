import java.util.*;

class Solution {
    
    boolean[][][] visited = new boolean[11][11][4];
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public int solution(String dirs) {
        char[] commands = dirs.toCharArray();
        
        int[] curr = new int[]{5, 5};
        int answer = 0;
        for (char c : commands) {
            int delta = 0, origin = 1;
            if (c == 'U') {
                delta = 0;
                origin = 1;
            }
            if (c == 'L') {
                delta = 2;
                origin = 3;
            }
            if (c == 'R') {
                delta = 3;
                origin = 2;
            }
            if (c == 'D') {
                delta = 1;
                origin = 0;
            }
            
            int x = curr[0] + dx[delta], y = curr[1] + dy[delta];
            
            if (x < 0 || x > 10 || y < 0 || y > 10) continue;
            if (!visited[x][y][delta]) {
                visited[curr[0]][curr[1]][origin] = true;
                visited[x][y][delta] = true;
                answer++;
            }
            curr = new int[]{x, y};
        }
        
        return answer;
    }
}