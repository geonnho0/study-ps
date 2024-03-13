import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            queue.offer(enemy[i]);
            
            if (n >= 0) {
                continue;
            }
            if (k > 0 && !queue.isEmpty()) {
                n += queue.poll();
                k--;
                continue;
            }
            return i;
        }
        return enemy.length;
    }
}