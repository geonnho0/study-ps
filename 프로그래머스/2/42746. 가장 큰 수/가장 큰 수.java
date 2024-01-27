import java.util.*;

class Solution {
    public String solution(int[] numbers) {
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