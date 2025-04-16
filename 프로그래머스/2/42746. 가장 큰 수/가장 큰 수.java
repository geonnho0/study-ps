import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strs = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s);
        return sb.toString();
    }
}