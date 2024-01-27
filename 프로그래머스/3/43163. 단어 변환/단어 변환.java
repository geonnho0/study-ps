import java.util.*;

class Solution {
    
    private int[] levels;
    private int total;
    private String[] totalWords;
    
    public int solution(String begin, String target, String[] words) {
        total = words.length + 1;
        levels = new int[total];
        totalWords = new String[total];
        totalWords[0] = begin;
        for (int i = 1; i < total; i++) totalWords[i] = words[i - 1];
        return bfs(target);
    }
    
    private int bfs(String target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
            
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int i = 1; i < total; i++) {
                if (levels[i] != 0) continue;
                if (!isOneDiff(totalWords[curr], totalWords[i])) continue;
                
                levels[i] = levels[curr] + 1;
                if (totalWords[i].equals(target)) return levels[i];
                queue.offer(i);
            }
        }
        return 0;
    }
    
    private boolean isOneDiff(String str1, String str2) {
        int length = str1.length();
        int count = 0;
        for (int i = 0; i < length; i++)
            if (str1.charAt(i) != str2.charAt(i)) count++;
        return count == 1;
    }
}