import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (arr1, arr2) -> {
            if (arr1[0] != arr2[0]) {
                return arr1[0] - arr2[0];
            }
            return arr1[1] - arr2[1];
        });
        int answer = 1;
        int s = -1, e = 100000001;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= s && targets[i][1] <= e) {
                s = targets[i][0];
                e = targets[i][1];
            }
            else if (targets[i][0] < e && targets[i][1] > e) {
                s = targets[i][0];
            }
            else {
                answer++;
                s = targets[i][0];
                e = targets[i][1];
            }
        }
        return answer;
    }
}