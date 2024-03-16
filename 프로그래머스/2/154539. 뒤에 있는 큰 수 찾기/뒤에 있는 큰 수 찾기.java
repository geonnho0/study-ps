import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            while (!stack.isEmpty() && stack.peek()[1] < num) {
                int[] s = stack.pop();
                answer[s[0]] = num;
            }
            stack.push(new int[]{i, num});
        }
        while (!stack.isEmpty()) {
            int[] s = stack.pop();
            answer[s[0]] = -1;
        }
        return answer;
    }
}