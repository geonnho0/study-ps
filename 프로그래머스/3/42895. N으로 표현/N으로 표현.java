import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++)
            dp.add(new HashSet<>());
        
        setNumber(dp, 1, N);
        
        for (int i = 2; i <= 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= i; j++)
                sb.append(N);
            setNumber(dp, i, Integer.parseInt(sb.toString()));
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        setNumber(dp, i, num1 + num2);
                        setNumber(dp, i, num1 - num2);
                        setNumber(dp, i, num1 * num2);
                        if (num2 != 0) {
                            setNumber(dp, i, num1 / num2);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number))
                return i;
        }
        return -1;
    }
    
    void setNumber(List<Set<Integer>> dp, int count, int number) {
        dp.get(count).add(number);
    }
}