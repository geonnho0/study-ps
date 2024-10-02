import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> q = new PriorityQueue<>((s1, s2) -> s2.compareTo(s1));
        q.offer("B");
        q.offer("A");
        q.offer("C");
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
        int length = numbers.length;
        String[] numberStrings = new String[length];
        for (int i = 0; i < length; i++)
            numberStrings[i] = String.valueOf(numbers[i]);
                                              
        Arrays.sort(numberStrings, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        
        if (numberStrings[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s: numberStrings) sb.append(s);
        return sb.toString();
    }
}