import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int item: scoville) queue.offer(item);
        int answer = 0;
        while (queue.size() >= 2 && queue.peek() < K) {
            int first = queue.poll();
            int second = queue.poll();
            int mixed = first + second * 2;
            queue.offer(mixed);
            answer++;
        }
        if (queue.peek() >= K)
            return answer;
        return -1;
    }
}