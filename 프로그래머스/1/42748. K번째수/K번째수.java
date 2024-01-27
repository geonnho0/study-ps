import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int[] command = commands[i];
            int[] copied = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(copied);
            answer[i] = copied[command[2] - 1];
        }
        return answer;
    }
}