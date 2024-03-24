import java.util.*;

class Solution {
    
    boolean[] visited;
    List<String> answers = new ArrayList<>();
    String[][] tickets;
    int maxLevel;
    
    public String[] solution(String[][] tickets) {
        init(tickets);
        dfs("ICN", "ICN", 0);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    
    void init(String[][] tickets) {
        maxLevel = tickets.length;
        this.tickets = tickets;
        visited = new boolean[maxLevel];
    }
    
    void dfs(String start, String route, int level) {
        if (level == maxLevel) {
            answers.add(route);
            return;
        }
        for (int i = 0; i < maxLevel; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], level + 1);
                visited[i] = false;
            }
        }
    }
    
}