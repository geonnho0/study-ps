import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int work : works)
            queue.offer(work);
        while (n-- > 0) {
            int work = queue.poll() - 1;
            queue.offer(work);
        }
        long answer = 0;
        while (!queue.isEmpty()) {
            int work = queue.poll();
            if (work <= 0)
                break;
            answer += (int) Math.pow(work, 2);
        }
        return answer;
    }
}