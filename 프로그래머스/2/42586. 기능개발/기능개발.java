import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = speeds.length;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curr = progresses[i];
            int daysToComplete = calculateComplete(curr, speeds[i]);
            
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                int next = progresses[j];
                int daysToComplete1 = calculateComplete(next, speeds[j]);
                
                if (daysToComplete < daysToComplete1) {
                    break;
                }
                
                count++;
            }
            
            i += (count - 1);
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    int calculateComplete(int progess, int speed) {
        return (int) Math.ceil((100 - progess) / (double) speed);
    }
}
