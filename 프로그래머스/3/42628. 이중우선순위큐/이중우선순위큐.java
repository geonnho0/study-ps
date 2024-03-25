import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>(), max = new PriorityQueue<>(Collections.reverseOrder());
        int len = 0;
        for (String operation : operations) {
            String[] op = operation.split(" ");
            if (len == 0) {
                min = new PriorityQueue<>();
                max = new PriorityQueue<>(Collections.reverseOrder());
            }
            if (op[0].equals("I")) {
                min.offer(Integer.parseInt(op[1]));
                max.offer(Integer.parseInt(op[1]));
                len++;
            }
            else if (len > 0) {
                len--;
                if (op[1].equals("1"))
                    max.poll();
                else
                    min.poll();
            }
        }
        if (len <= 0)
            return new int[]{0, 0};
        return new int[]{max.poll(), min.poll()};
    }
}