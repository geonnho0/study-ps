import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] dp = new int[N + 5];
        dp[1] = 1;
        dp[3] = 1;
        for (int i = 1; i <= N; i++) {
            if (i + 1 > N || i + 3 > N) continue;
            dp[i + 1] = dp[i] == 1 ? 2 : 1;
            dp[i + 3] = dp[i] == 1 ? 2 : 1;
        }
        System.out.println(dp[N] == 1 ? "SK" : "CY");
    }
}