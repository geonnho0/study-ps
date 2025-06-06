import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0, right = (long) n * times[times.length - 1];
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            
            long peopleCount = 0;
            for (int time : times) {
                peopleCount += (mid / time);
            }
            
            if (peopleCount < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}
