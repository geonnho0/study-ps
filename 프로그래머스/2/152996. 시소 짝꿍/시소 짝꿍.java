import java.util.*;

class Solution {
    
    Map<Double, Integer> mates = new HashMap<>();
    long answer = 0;
    
    public long solution(int[] weights) {
        Arrays.sort(weights);
        for (int w : weights) {
            double weight = w * 1.0;
            double twoThree = (w * 2.0) / 3.0;
            double twoFour = (w * 1.0) / 2.0;
            double threeFour = (w * 3.0) / 4.0;
            check(weight);
            check(twoThree);
            check(twoFour);
            check(threeFour);
            mates.put(weight, mates.getOrDefault(weight, 0) + 1);
        }
        return answer;
    }
    
    void check(double key) {
        if (mates.containsKey(key)) {
            answer += mates.get(key);
        }
    }
    
}