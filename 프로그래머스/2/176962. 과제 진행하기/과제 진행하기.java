import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Task> queue = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start));
        for (String[] p : plans) {
            String[] str = p[1].split(":");
            int start = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
            queue.offer(new Task(p[0], start, Integer.parseInt(p[2])));
        }

        Stack<Task> remain = new Stack<>();
        int i = 0;
        while(!queue.isEmpty()) {
            Task curr = queue.poll();
            int currTime = curr.start;
            if (!queue.isEmpty()) {
                Task next = queue.peek();

                if (currTime + curr.playtime < next.start) {
                    answer[i++] = curr.name;
                    currTime += curr.playtime;

                    while (!remain.isEmpty()) {
                        Task re = remain.pop();

                        if (currTime + re.playtime <= next.start) {
                            answer[i++] = re.name;
                            currTime += re.playtime;
                            continue;
                        }

                        re.playtime -= (next.start - currTime);
                        remain.push(re);
                        break;
                    }
                }
                else if (currTime + curr.playtime == next.start) {
                    answer[i++] = curr.name;
                }
                else {
                    curr.playtime -= (next.start - currTime);
                    remain.push(curr);
                }
                continue;
            }
            answer[i++] = curr.name;
            if (!remain.isEmpty()) {
                while (!remain.isEmpty()) {
                    answer[i++] = remain.pop().name;
                }
            }
        }
        return answer;
    }
}

class Task {
    String name;
    int start, playtime;

    public Task(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
}