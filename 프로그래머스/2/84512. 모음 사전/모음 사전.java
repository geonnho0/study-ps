class Solution {
    boolean flag = false;
    int answer = 0;
    String word;
    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        this.word = word;
        dfs("");
        return answer - 1;
    }
    
    void dfs(String str) {
        answer++;
        if (str.equals(word)) {
            flag = true;
            return;
        }
            
        if (str.length() == 5)
            return;
        
        for (int i = 0; i < 5 && !flag; i++) {
            dfs(str + alphabet[i]);
        }
    }
}