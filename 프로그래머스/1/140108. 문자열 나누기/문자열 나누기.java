class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        int answer = 0;
        
        int cnt1 = 1, cnt2 = 0;
        char x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            char another = arr[i];
            if (x == another) {
                cnt1++;
                continue;
            }
            cnt2++;
            if (cnt1 == cnt2) {
                answer++;
                cnt1 = 1;
                cnt2 = 0;
                if (i == arr.length - 1) {
                    cnt1 = 0;
                    break;
                }
                x = arr[++i];
            }
        }
        if (cnt1 != 0) {
            answer++;
        }
        return answer;
    }
}