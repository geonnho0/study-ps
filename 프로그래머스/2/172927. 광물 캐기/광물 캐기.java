import java.util.*;

class Solution {
    
    int min = Integer.MAX_VALUE;
    int[] picks;
    String[] minerals;
    
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
        dfs(0, -1, 0, 0);
        return min;
    }
    
    void dfs(int index, int currPick, int leftCount, int tired) {
        if (index == minerals.length || usedAll(leftCount)) {
            min = Math.min(tired, min);
            return;
        }
        
        if (leftCount > 0) {
            if (currPick == 0) {
                dfs(index + 1, currPick, leftCount - 1, tired + 1);
            }
            else if (currPick == 1) {
                if (minerals[index].equals("diamond")) {
                    dfs(index + 1, currPick, leftCount - 1, tired + 5);
                }
                else {
                    dfs(index + 1, currPick, leftCount - 1, tired + 1);
                }
            }
            else {
                if (minerals[index].equals("diamond")) {
                    dfs(index + 1, currPick, leftCount - 1, tired + 25);
                }
                else if (minerals[index].equals("iron")) {
                    dfs(index + 1, currPick, leftCount - 1, tired + 5);
                }
                else {
                    dfs(index + 1, currPick, leftCount - 1, tired + 1);
                }
            }
            return;
        }
        
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) {
                continue;
            }
            picks[i]--;
            dfs(index, i, 5, tired);
            picks[i]++;
        }
    }
    
    boolean usedAll(int leftCount) {
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] != 0) {
                return false;
            }
        }
        return leftCount == 0;
    }
}