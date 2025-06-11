import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        char[] arr = skill.toCharArray();
        Map<Character, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (char c : arr)
            indexMap.put(c, index++);
        
        int answer = 0;
        for (String s : skill_trees) {
            if (validate(s, indexMap))
                answer++;
        }
        return answer;
    }
    
    boolean validate(String tree, Map<Character, Integer> indexMap) {
        char[] arr = tree.toCharArray();
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (indexMap.get(arr[i]) == null)
                continue;
            int index = indexMap.get(arr[i]);
            if (index != curr)
                return false;
            curr++;
        }
        return true;
    }
}