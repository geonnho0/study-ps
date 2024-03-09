class Solution {
    
    char[][] origin = new char[3][3];
    char[][] graph = new char[3][3];
    int answer = 0;
    
    public int solution(String[] board) {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                origin[i][j] = board[i].charAt(j);
                graph[i][j] = '.';
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (same()) {
                    return 1;
                }
                graph[i][j] = 'O';
                find(i, j, true, 1);
                graph[i][j] = '.';
            }
        }
        
        return answer;
    }
    
    public void find(int x, int y, boolean isX, int count) {
        if (answer == 1) {
            return;
        }
        if (count == 9) {
            if (same()) {
                answer = 1;
            }
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (graph[i][j] != '.') {
                    continue;
                }
                graph[i][j] = isX ? 'X' : 'O';
                if (same()) {
                    answer = 1;
                    return;
                }
                if (!isOver()) {
                    find(i, j, !isX, count + 1);
                }
                graph[i][j] = '.';
            }
        }
    }
    
    public boolean same() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (origin[i][j] != graph[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isOver() {
        for (int i = 0; i < 3; i++) {
            if (horizontal(i) || vertical(i)) {
                return true;
            }
        }
        return cross();
    }
    
    public boolean horizontal(int row) {
        if (graph[row][0] == '.') {
            return false;
        }
        return graph[row][0] == graph[row][1] && graph[row][0] == graph[row][2];
    }
    
    public boolean vertical(int col) {
        if (graph[0][col] == '.') {
            return false;
        }
        return graph[0][col] == graph[1][col] && graph[0][col] == graph[2][col];
    }
    
    public boolean cross() {
        if (graph[1][1] == '.') {
            return false;
        }
        if (graph[0][0] == graph[1][1] && graph[0][0] == graph[2][2]) {
            return true;
        }
        if (graph[0][2] == graph[1][1] && graph[0][2] == graph[2][0]) {
            return true;
        }
        return false;
    }
    
}