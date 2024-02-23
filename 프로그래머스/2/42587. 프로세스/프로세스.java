import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Process> process = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            process.add(new Process(priority, i));
        }
        while (!process.isEmpty()) {
            Process curr = process.get(0);
            process.remove(0);
            boolean exist = false;
            for (Process p: process) {
                if (curr.p < p.p) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                process.add(curr);
                continue;
            }
            answer++;
            if (curr.i == location) {
                break;
            }
        }
        return answer;
    }
}

class Process {
    int p, i;
    
    public Process(int p, int i) {
        this.p = p;
        this.i = i;
    }
}