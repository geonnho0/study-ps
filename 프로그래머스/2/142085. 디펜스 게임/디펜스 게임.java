import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> defendedCount = new PriorityQueue<>(Collections.reverseOrder());
        
        int answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            n -= e;
            defendedCount.offer(e);
            if (n >= 0)
                continue;
            
            if (k > 0 && !defendedCount.isEmpty()) {
                k--;
                n += defendedCount.poll();
                continue;
            }
            
            return i;
        }
        return enemy.length;
    }
}
