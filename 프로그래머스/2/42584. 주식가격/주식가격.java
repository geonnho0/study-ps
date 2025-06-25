import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> s = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!s.isEmpty() && s.peek()[0] > prices[i]) {
                int[] last = s.pop();
                answer[last[1]] = i - last[1];
            }
            s.push(new int[]{prices[i], i});
        }
        
        while (!s.isEmpty()) {
            int[] last = s.pop();
            answer[last[1]] = prices.length - 1 - last[1];
        }
        
        return answer;
    }
}