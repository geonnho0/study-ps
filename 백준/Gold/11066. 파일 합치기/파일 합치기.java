import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] sum = new int[501];
            for (int i = 1; i <= K; i++) {
                int num = Integer.parseInt(line[i - 1]);
                sum[i] = sum[i - 1] + num;
            }
            int[][] dp = new int[501][501];
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= K - i; j++) {
                    dp[j][i + j] = Integer.MAX_VALUE;
                    for (int k = j; k < i + j; k++) {
                        dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + sum[i + j] - sum[j - 1]);
                    }
                }
            }
            sb.append(dp[1][K]).append("\n");
        }
        System.out.print(sb);
    }
}