import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Truck> queue = new LinkedList<>();
        queue.offer(new Truck(answer, truck_weights[0]));
        int currWeight = truck_weights[0], index = 1;
        while (!queue.isEmpty()) {
            answer++;
            while (!queue.isEmpty() && answer - queue.peek().startTime == bridge_length) {
                Truck out = queue.poll();
                currWeight -= out.weight;
            }
            
            if (index < truck_weights.length) {
                if (currWeight + truck_weights[index] <= weight) {
                    queue.offer(new Truck(answer, truck_weights[index]));
                    currWeight += truck_weights[index];
                    index++;
                }
            }
        }
        return answer;
    }
}

class Truck {
    int startTime, weight;
    
    public Truck(int startTime, int weight) {
        this.startTime = startTime;
        this.weight = weight;
    }
}