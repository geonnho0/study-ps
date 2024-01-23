import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] dp = new int[N + 5];
        int[] T = new int[N + 5];
        int[] P = new int[N + 5];
        for (int i = 1; i <= N; i++) {
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            if (i + T[i] > N + 1) continue;
            int end = i + T[i];
            int max = dp[1];
            for (int j = 2; j <= i; j++) max = Math.max(max, dp[j]);
            dp[end] = Math.max(dp[end], max + P[i]);
        }
        int max = 0;
        for (int res: dp)
            max = Math.max(res, max);
        System.out.println(max);
    }

}