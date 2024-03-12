import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = getTotalGCD(arrayA), b = getTotalGCD(arrayB);
        for (int num : arrayB) {
            if (num % a == 0) {
                a = 0;
                break;
            }
        }
        for (int num : arrayA) {
            if (num % b == 0) {
                b = 0;
                break;
            }
        }
        if (a == b) {
            return 0;
        }
        return Math.max(a, b);
    }
    
    int getTotalGCD(int[] array) {
        Arrays.sort(array);
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            res = gcd(res, array[i]);
        }
        return res;
    }
    
    int gcd(int big, int small) {
        while(big % small != 0) {
            int r = big % small;
            big = small;
            small = r;
        }
        return small;
    }
}