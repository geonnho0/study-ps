import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            int bound = (int) Math.sqrt(i);
            for (int j = 1; j <= bound; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        System.out.print(dp[N]);
    }

}