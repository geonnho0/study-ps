import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            line = br.readLine().split(" ");
            weight[i] = Integer.parseInt(line[0]);
            value[i] = Integer.parseInt(line[1]);
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.print(dp[N][K]);
    }

}