import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> processes = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++)
            processes.add(i);
        while (true) {
            int curr = processes.get(0);
            boolean canExcute = true;
            for (int i = 1; i < processes.size() && canExcute; i++) {
                int next = processes.get(i);
                if (priorities[curr] < priorities[next])
                    canExcute = false;
            }
            processes.remove(0);
            if (!canExcute) {
                processes.add(curr);
                continue;
            }
            answer++;
            if (location == curr) 
                break;
        }
        return answer;
    }
}