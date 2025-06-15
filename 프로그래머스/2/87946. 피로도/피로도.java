class Solution {
    int[][] dungeons;
    boolean[] visited;
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        enter(k, 0);
        return answer;
    }
    
    void enter(int curr, int stage) {
        answer = answer < stage ? stage : answer;
        
        if (stage == dungeons.length)
            return;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i])
                continue;
            
            int[] next = dungeons[i];
            if (curr < next[0])
                continue;
            visited[i] = true;
            enter(curr - next[1], stage + 1);
            visited[i] = false;
        }
    }
}