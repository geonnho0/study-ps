import java.util.*;

class Solution {
    boolean[] visited = new boolean[101];
    int[] cards = new int[101];
    List<Integer> list = new ArrayList<>();
    
    public int solution(int[] cards) {
        for (int i = 1; i <= cards.length; i++) {
            this.cards[i] = cards[i - 1];
        }
        
        for (int i = 1; i <= cards.length; i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
        }
        if (list.size() == 1) {
            return 0;
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);
        int answer = list.get(0) * list.get(1);
        return answer;
    }
    
    void dfs(int index, int count) {
        if (visited[index]) {
            list.add(count);
            return;
        }
        visited[index] = true;
        int card = cards[index];
        dfs(card, count + 1);
    }
    
}