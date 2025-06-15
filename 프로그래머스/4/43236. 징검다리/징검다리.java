import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (removedRocksCount(distance, rocks, mid) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    
    int removedRocksCount(int distance, int[] rocks, int minInterval) {
        int baseIndex = 0;
        int count = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - baseIndex < minInterval)
                count++;
            else
                baseIndex = rocks[i];
        }
        if (distance - baseIndex < minInterval)
            count++;
        return count;
    }
}
