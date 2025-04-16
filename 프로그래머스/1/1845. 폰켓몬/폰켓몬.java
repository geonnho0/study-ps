import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> ponkemon = new HashMap<>();
        for (int n : nums) {
            ponkemon.put(n, ponkemon.getOrDefault(n, 0) + 1);
        }
        int total = ponkemon.keySet().size();
        return Math.min(total, nums.length / 2);
    }
}