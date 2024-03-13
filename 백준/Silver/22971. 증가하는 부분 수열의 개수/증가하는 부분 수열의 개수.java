import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] A = new int[N + 1];
        for (int i = 0; i < N; i++) {
            A[i + 1] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print((dp[i] % MOD) + " ");
        }
    }

}