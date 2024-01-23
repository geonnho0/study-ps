import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        dp = new int[N + 5];
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            int three = Integer.MAX_VALUE, two = Integer.MAX_VALUE, one;
            if (i % 3 == 0) three = dp[i / 3] + 1;
            if (i % 2 == 0) two = dp[i / 2] + 1;
            one = dp[i - 1] + 1;
            int min = Math.min(three, two);
            dp[i] = Math.min(min, one);
        }
        System.out.println(dp[N]);
    }

}