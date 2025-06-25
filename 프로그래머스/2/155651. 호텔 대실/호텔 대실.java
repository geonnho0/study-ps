import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (bt1, bt2) -> {
            if (bt1[0].equals(bt2[0])) {
                return bt1[1].compareTo(bt2[1]);
            }
            return bt1[0].compareTo(bt2[0]);
        });
        
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        int answer = 0;
        for (String[] b : book_time) {
            if (pq.isEmpty()) pq.offer(b[1]);
            else {
                if (isOver10min(pq.peek(), b[0]))
                    pq.poll();
                    
                pq.offer(b[1]);
            }
            answer = Math.max(answer, pq.size());
        }
        
        
        return answer;
    }
    
    boolean isOver10min(String t1, String t2) {
        String[] temp = t1.split(":");
        int time1 = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        temp = t2.split(":");
        int time2 = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        return time2 - time1 >= 10;
    }
}