import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int[][] dp = new int[N + 1][M + 1];
            for (int i = 1; i <= M; i++) {
                dp[1][i] = i;
            }
            for (int i = 2; i <= N; i++) {
                for (int j = i; j <= M; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
            System.out.println(dp[N][M]);
        }
    }

}