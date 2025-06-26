import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new LinkedList<>();
        int currentWeight = truck_weights[0];
        q.offer(new int[]{currentWeight, 0});
        int truckIdx = 1;
        int truckCount = truck_weights.length;
        int answer = 1;
        while (!q.isEmpty()) {
            while (!q.isEmpty() && (answer - q.peek()[1]) >= bridge_length) {
                int[] t = q.poll();
                currentWeight -= t[0];
            }
            
            if (truckIdx < truckCount && currentWeight + truck_weights[truckIdx] <= weight) {
                q.offer(new int[]{truck_weights[truckIdx], answer});
                currentWeight += truck_weights[truckIdx++];
            }
            
            answer++;
        }
        return answer;
    }
}