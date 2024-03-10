import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] distances = new int[y + 1];
        for (int i = x; i <= y; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[x] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            int plusN = curr + n;
            if (plusN <= y) {
                if (distances[plusN] > distances[curr] + 1) {
                    distances[plusN] = distances[curr] + 1;
                    queue.offer(plusN);    
                }
            }
            int mulTwo = curr * 2;
            if (mulTwo <= y) {
                if (distances[mulTwo] > distances[curr] + 1) {
                    distances[mulTwo] = distances[curr] + 1;
                    queue.offer(mulTwo);
                }
            }
            int mulThree = curr * 3;
            if (mulThree <= y) {
                if (distances[mulThree] > distances[curr] + 1) {
                    distances[mulThree] = distances[curr] + 1;
                    queue.offer(mulThree);    
                }
            }
        }
        return distances[y] == Integer.MAX_VALUE ? -1 : distances[y];
    }
}