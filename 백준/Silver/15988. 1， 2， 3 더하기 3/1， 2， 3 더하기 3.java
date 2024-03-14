import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 1000001; i++) {
            dp[i] = (((dp[i - 1] + dp[i - 2]) % MOD) + dp[i - 3]) % MOD;
        }
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }

}