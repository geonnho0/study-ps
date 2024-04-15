import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            int j = i + 1;
            for (; j < n; j++) {
                if (progresses[j] + speeds[j] * days < 100)
                    break;
            }
            count.add(j - i);
            i = j - 1;
        }
        return count.stream().mapToInt(Integer::intValue).toArray();
    }
}