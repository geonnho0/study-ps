import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int numberLength, maxReverseCount;
    private static int[][] xDigit;
    private static int[][] digits = {{1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        numberLength = Integer.parseInt(st.nextToken());
        maxReverseCount = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        xDigit = numToDigit(X);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X && canReverse(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static int[][] numToDigit(int num) {
        int[][] digit = new int[numberLength][7];
        for (int i = numberLength - 1; i >= 0; i--) {
            digit[i] = digits[num % 10];
            num /= 10;
        }
        return digit;
    }

    private static boolean canReverse(int target) {
        int[][] targetDigit = numToDigit(target);
        int count = 0;
        for (int i = 0; i < numberLength; i++) {
            count += reverseCount(xDigit[i], targetDigit[i]);
        }
        return count <= maxReverseCount;
    }

    private static int reverseCount(int[] src, int[] dst) {
        int ans = 0;
        for (int i = 0; i < 7; i++) {
            if (src[i] != dst[i]) {
                ans++;
            }
        }
        return ans;
    }
}