import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subBelt = new Stack<>();
        int answer = 0;
        int curr = 1;
        for (int o : order) {
            if (curr <= o) {
                while (curr != o)
                    subBelt.push(curr++);
                curr++;
                answer++;
                continue;
            }
            
            if (subBelt.isEmpty() || subBelt.peek() != o)
                return answer;
            
            subBelt.pop();
            answer++;
        }
        return answer;
    }
}