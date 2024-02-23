import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        generateNumbers("", numbers);
        int ans = 0;
        for (int num : set) {
            if (isPrime(num)) {
                ans++;
            }
        }
        return ans;
    }
    
    public void generateNumbers(String curr, String other) {
        String temp = curr;
        while (!temp.isEmpty() && temp.charAt(0) == '0') {
            temp = temp.substring(1);
        }
        if (!temp.isEmpty()) {
            set.add(Integer.parseInt(curr));    
        }
        for (int i = 0; i < other.length(); i++) {
            String tmp = "";
            if (i == 0) {
                tmp = other.substring(1);
            } else if (i == other.length() - 1) {
                tmp = other.substring(0, i);
            } else {
                tmp = other.substring(0, i) + other.substring(i + 1);
            }
            generateNumbers(curr + other.charAt(i), tmp);
        }
    }
    
    public boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        int bound = (int) Math.sqrt(number);
        for (int i = 2; i <= bound; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}