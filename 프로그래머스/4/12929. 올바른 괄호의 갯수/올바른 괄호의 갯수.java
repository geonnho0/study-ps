import java.util.*;

class Solution {
    int answer = 0;
    int n;
    List<Character> list = new ArrayList<>();
    
    public int solution(int n) {
        this.n = 2 * n;
        dfs(0);
        return answer;
    }
    
    void dfs(int n) {
        if (n == this.n) {
            if (check())
                answer++;
            return;
        }
        
        list.add('(');
        dfs(n + 1);
        list.remove(list.size() - 1);
        list.add(')');
        if (canContinue())
            dfs(n + 1);
        list.remove(list.size() - 1);
    }
    
    boolean check() {
        Stack<Character> stack = new Stack<>();
        for (Character l : list) {
            if (l == '(') {
                stack.push(l);
                continue;
            }
            if (stack.isEmpty()) 
                return false;
            if (stack.pop() == ')') 
                return false;
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
    
    boolean canContinue() {
        int count = 0;
        for (Character l : list) {
            if (l == '(')
                count++;
        }
        if (count * 2 < list.size())
            return false;
        if (count * 2 > n)
            return false;
        return true;
    }
}