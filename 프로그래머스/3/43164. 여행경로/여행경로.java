import java.util.*;

class Solution {
    boolean[] visited;
    String[][] tickets;
    int totalCount;
    String answer = "";
    public String[] solution(String[][] tickets) {
        totalCount = tickets.length;
        visited = new boolean[totalCount];
        Arrays.sort(tickets, (t1, t2) -> {
            if (t1[0].equals(t2[0]))
                return t1[1].compareTo(t2[1]);
            return t1[0].compareTo(t2[1]);
        });
        this.tickets = tickets;
        
        dfs("ICN", ("ICN"), 0);
        return answer.split(" ");
    }
    
    void dfs(String current, String route, int visitedCount) {
        if (!answer.equals(""))
            return;

        if (visitedCount == totalCount) {
            answer = route;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i])
                continue;
            
            if (!current.equals(tickets[i][0]))
                continue;
            
            visited[i] = true;
            dfs(tickets[i][1], route + " " + tickets[i][1], visitedCount + 1);
            visited[i] = false;
        }
    }
}