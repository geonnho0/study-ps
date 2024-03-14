import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> old = new HashMap<>(), young = new HashMap<>();
        for (int t : topping) {
            young.put(t, young.getOrDefault(t, 0) + 1);
        }
        for (int t : topping) {
            old.put(t, old.getOrDefault(t, 0) + 1);
            young.put(t, young.get(t) - 1);
            if (young.get(t) == 0) {
                young.remove(t);
            }
            if (old.size() == young.size()) {
                answer++;
            }
        }
        return answer;
    }
}