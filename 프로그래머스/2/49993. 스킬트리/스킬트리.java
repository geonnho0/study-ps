import java.util.*;

class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int[] sequence = new int[26];
        for (int i = 0; i < skill.length(); i++)
            sequence[skill.charAt(i) - 'A'] = i + 1;
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String curr = skill_trees[i];
            int index = 0;
            boolean flag = true;
            for (int j = 0; j < curr.length() && flag; j++) {
                int seq = sequence[curr.charAt(j) - 'A'];
                if (seq == 0)
                    continue;
                if (seq - index != 1)
                    flag = false;
                index++;
            }
            if (flag)
                answer++;
        }
        return answer;
    }
    
}