import java.util.*;

class Solution {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        ArrayList<String> list = new ArrayList<>();
        while (n != 0) {
            int index = n % 3;
            n /= 3;
            if (index == 0) {
                n--;
            }
            list.add(num[index]);
        }
        Collections.reverse(list);
        return list.stream().reduce(String::concat).get();
    }
}