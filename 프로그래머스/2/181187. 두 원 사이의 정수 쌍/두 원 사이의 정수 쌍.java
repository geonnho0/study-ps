import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int i = r2; i > 0; i--) {
            int minY = (int) Math.ceil(getY(i, r1));
            int maxY = (int) Math.floor(getY(i, r2));
            answer += (maxY - minY + 1);
        }
        return answer * 4;
    }
    
    public double getY(int x, int r) {
        return Math.sqrt(1.0 * r * r - 1.0 * x * x);
    }
}