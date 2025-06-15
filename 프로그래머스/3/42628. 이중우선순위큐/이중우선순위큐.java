import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = null, max = null;
        int size = 0;
        for (String command : operations) {
            char op = command.charAt(0);
            
            if (size == 0) {
                min = new PriorityQueue<Integer>();
                max = new PriorityQueue<Integer>(Collections.reverseOrder());
            }
            
            int arg = Integer.valueOf(command.split(" ")[1]);
            if (op == 'I') {
                size++;
                min.offer(arg);
                max.offer(arg);
            }
            else if (size > 0) {
                size--;
                if (arg == -1)
                    max.remove(min.poll());
                else
                    min.remove(max.poll());
            }
        }
        
        if (size <= 0)
            return new int[]{0, 0};
        return new int[]{max.poll(), min.poll()};
    }
}