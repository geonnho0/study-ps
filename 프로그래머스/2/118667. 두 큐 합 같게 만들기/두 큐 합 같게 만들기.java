import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int max = 0;
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
            sum2 += queue2[i];
            q2.offer(queue2[i]);
            max = Math.max(max, queue1[i]);
            max = Math.max(max, queue2[i]);
        }
        int limit = queue1.length * 4;
        long total = (sum1 + sum2);
        if (total % 2 != 0) {
            return -1;
        }
        if (max > total / 2) {
            return -1;
        }
        long mid = total / 2;
        int count = 0;
        while (sum1 != sum2) {
            while (mid < sum2) {
                int pop = q2.poll();
                sum2 -= pop;
                q1.offer(pop);
                sum1 += pop;
                count++;
            }
            if (sum2 == mid) {
                return count;
            }
            while (mid < sum1) {
                int pop = q1.poll();
                sum1 -= pop;
                q2.offer(pop);
                sum2 += pop;
                count++;
            }
            if (count > limit) {
                return -1;
            }
        }
        return count;
    }
}