import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = {scores[0][0], scores[0][1]};
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]));
        
        int k = scores[0][1];
        for (int[] score : scores) {
            if (k <= score[1]) {
                k = score[1];
                continue;
            }
            if (target[0] == score[0] && target[1] == score[1]) {
                return -1;
            }
            score[0] = -1;
            score[1] = -1;
        }
        
        Arrays.sort(scores, (o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]);
        for (int i = 0; i < scores.length; i++) {
            if (target[0] == scores[i][0] && target[1] == scores[i][1]) {
                return i + 1;
            }
        }
        
        return -1;
    }
}