import java.util.*;

class Solution {
    
    boolean[][][][] visited = new boolean[11][11][11][11];
    int[] curr = {5, 5}, next = {-1, -1};
    
    public int solution(String dirs) {
        int answer = 0;
        String[] command = dirs.split("");
        for (String c: command) {
            if (c.equals("U")) {
                next[0] = curr[0] - 1;
                next[1] = curr[1];
            }
            else if (c.equals("D")) {
                next[0] = curr[0] + 1;
                next[1] = curr[1];
            }
            else if (c.equals("L")) {
                next[0] = curr[0];
                next[1] = curr[1] - 1;
            }
            else if (c.equals("R")) {
                next[0] = curr[0];
                next[1] = curr[1] + 1;
            }
            
            if (isNotValid(next[0], next[1])) {
                continue;
            }
            if (!visited[curr[0]][curr[1]][next[0]][next[1]]) {
                visited[curr[0]][curr[1]][next[0]][next[1]] = true;
                visited[next[0]][next[1]][curr[0]][curr[1]] = true;
                answer++;
            }
            curr[0] = next[0];
            curr[1] = next[1];
        }
        return answer;
    }
    
    private boolean isNotValid(int x, int y) {
        return x < 0 || x > 10 || y < 0 || y > 10;
    }
}