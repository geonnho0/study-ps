import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        PriorityQueue<Tanger> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        Map<Integer, Integer> map = new HashMap<>();
        for (int tanger : tangerine) {
            map.put(tanger, map.getOrDefault(tanger, 0) + 1);
        }
        for (int key : map.keySet()) {
            int count = map.get(key);
            queue.offer(new Tanger(key, count));
        }
        int answer = 0;
        while (k > 0) {
            Tanger curr = queue.poll();
            while (curr.count-- > 0) {
                k--;
            }
            answer++;
            
        }
        return answer;
    }
}

class Tanger {
    int size, count;
    
    public Tanger(int s, int c) {
        size = s;
        count = c;
    }
}

