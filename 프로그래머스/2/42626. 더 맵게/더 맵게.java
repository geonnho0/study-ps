import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : scoville) q.offer(s);
        int answer = 0;
        while (q.size() >= 2 && q.peek() < K) {
            q.offer(q.poll() + 2 * q.poll());
            answer++;
        }
        if (q.peek() < K) return -1;
        return answer;
    }
}