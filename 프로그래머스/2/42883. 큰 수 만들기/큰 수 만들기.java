import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int N = number.length();
        int sbLen = N - k, start = 0;
        while (start < N && sb.length() != sbLen) {
            int leftNum = k + sb.length() + 1;
            int max = 0;
            for (int j = start; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            sb.append(String.valueOf(max));
        }
        return sb.toString();
    }
}