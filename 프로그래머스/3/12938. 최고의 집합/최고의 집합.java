import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s)
            return new int[]{-1};
        int num = s / n;
        int[] answer = new int[n];
        answer[0] = num;
        for (int i = 1; i < n; i++) {
            s -= answer[i - 1];
            answer[i] = s / (n - i);
        }
        return answer;
    }
}