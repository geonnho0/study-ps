import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int total = 0;
        for (Integer num : number) {
            total += num;
        }
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        for (int i = 0; i < total; i++) {
            if (map.containsKey(discount[i])) {
                int v = map.get(discount[i]);
                map.put(discount[i], v - 1);
            }
        }
        int answer = check() ? 1 : 0;
        for (int i = total; i < discount.length; i++) {
            if (map.containsKey(discount[i - total])) {
                int v = map.get(discount[i - total]);
                map.put(discount[i - total], v + 1);    
            }
            if (map.containsKey(discount[i])) {
                int v = map.get(discount[i]);
                map.put(discount[i], v - 1);    
            }
            if (check()) {
                answer++;
            }
        }
        return answer;
    }
    
    boolean check() {
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}