class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            answer *= 10;
            if (c >= '0' && c <= '9') {
                answer += (c - '0');
                i++;
                continue;
            }
            if (c == 'z') {
                i += 4;
                continue;
            }
            if (c == 'o') {
                answer += 1;
                i += 3;
                continue;
            }
            char t = s.charAt(i + 1);
            if (c == 't') {
                answer += (t == 'w' ? 2 : 3);
                i += (t == 'w' ? 3 : 5);
            } else if (c == 'f') {
                answer += (t == 'o' ? 4 : 5);
                i += 4;
            } else if (c == 's') {
                answer += (t == 'i' ? 6 : 7);
                i += (t == 'i' ? 3 : 5);
            } else if (c == 'e') {
                answer += 8;
                i += 5;
            } else {
                answer += 9;
                i += 4;
            }
        }
        return answer;
    }
}