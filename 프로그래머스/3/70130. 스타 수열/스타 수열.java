import java.util.*;

class Solution {
    public int solution(int[] a) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int aa : a)
            count.put(aa, count.getOrDefault(aa, 0) + 1);
        int answer = -1;
        
        for (int key : count.keySet()) {
            if (count.get(key) <= answer) continue;
            
            int cnt = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] == a[i + 1]) continue;
                if (a[i] != key && a[i + 1] != key) continue;
                cnt++;
                i++;  // 다음 집합으로 이동
            }
            answer = Math.max(answer, cnt);
        }
        return answer * 2;
    }
}
