import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> r1[0] - r2[0]);
        int min = routes[0][1];
        int answer = 1;
        for (int[] route : routes) {
            if (min >= route[0])
                min = Math.min(min, route[1]);
            else {
                min = route[1];
                answer++;
            }
        }
        return answer;
    }
}