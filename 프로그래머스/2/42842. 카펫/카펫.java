import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;
        int bound = (int) Math.sqrt(totalSize);
        int[] answer = {0, 0};
        for (int width = bound; ; width++) {
            if (totalSize % width != 0) {
                continue;
            }
            int height = totalSize / width;
            if (height > width) {
                continue;
            }
            if (brown != (width + height) * 2 - 4) {
                continue;
            }
            answer[0] = width;
            answer[1] = height;
            break;
        }
        return answer;
    }
}
