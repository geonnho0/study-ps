import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int curr = prices[i];
            while (!stack.isEmpty() && stack.peek()[1] > curr) {
                int[] stock = stack.pop();
                answer[stock[0]] = i - stock[0];
            }
            stack.push(new int[]{i, curr});
        }
        while (!stack.isEmpty()) {
            int[] stock = stack.pop();
            answer[stock[0]] = N - stock[0] - 1;
        }
        return answer;
    }
}