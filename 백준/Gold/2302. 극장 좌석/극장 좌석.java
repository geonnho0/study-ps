import java.io.*;
import java.util.*;

public class Main {

    private static int solution(int n, List<Integer> seats) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (!seats.contains(i) && !seats.contains(i - 1)) dp[i] += dp[i - 2];
        }

        return dp[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer> seats = new ArrayList<>();
        for (int i = 0; i < m; i++)
            seats.add(Integer.parseInt(br.readLine()));
        System.out.println(solution(n, seats));
    }
}