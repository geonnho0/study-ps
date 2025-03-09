import java.util.*;

class Solution {
    public int solution(String t, String p) {
        char[] arr = t.toCharArray();
        char[] temp = p.toCharArray();
        List<Character> list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            
            if (list.size() != temp.length) continue;
            if (!compare(list, temp)) answer++;
            
            list.remove(0);
        }
        return answer;
    }
    
    public boolean compare(List<Character> a, char[] b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b[i]) return true;
            if (a.get(i) < b[i]) return false;
        }
        return false;
    }
}