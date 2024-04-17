import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> wait = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> doing = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int[] job: jobs)
            wait.offer(job);
        int waitTime = 0, costTime = 0, idle = 0, count = 0;
        
        while (count < jobs.length) {
            while (!wait.isEmpty() && wait.peek()[0] <= costTime)
                doing.offer(wait.poll());
            
            if (doing.isEmpty()) {
                idle += wait.peek()[0] - costTime;
                costTime = wait.peek()[0];
                continue;
            }
            int[] job = doing.poll();
            waitTime += costTime - job[0];
            costTime += job[1];
            count++;
        }
        return (waitTime + costTime - idle) / jobs.length;
    }
}