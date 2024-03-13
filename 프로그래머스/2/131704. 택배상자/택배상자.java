import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int container = 1;
        Stack<Integer> subContainer = new Stack<>();
        for (int o : order) {
            if (container == o) {
                container++;
                answer++;
                continue;
            }
            if (container > o) {
                if (subContainer.isEmpty() || subContainer.peek() != o) {
                    break;
                }
                subContainer.pop();
                answer++;
                continue;
            }
            while (container < o) {
                subContainer.push(container++);
            }
            container++;
            answer++;
        }
        return answer;
    }
}