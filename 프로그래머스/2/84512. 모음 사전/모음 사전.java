class Solution {
    char[] alphabet = new char[]{'A', 'E', 'I', 'O', 'U'};
    String target;
    int answer;
    public int solution(String word) {
        target = word;
        
        find("", 0);
        return answer;
    }
    
    int find(String curr, int order) {
        if (curr.equals(target)) {
            answer = order;
            return order;
        }
        
        if (curr.length() == 5) {
            return order;
        }
        
        int next = order + 1;
        for (int i = 0; i < 5; i++)
            next = find(curr + alphabet[i], next) + 1;
        
        return next - 1;
    }
}