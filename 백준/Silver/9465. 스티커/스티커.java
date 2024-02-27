import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 5];
            for (int i = 0; i < 2; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
            int[][] dp = new int[2][n + 5];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];
            for (int i = 2; i < n; i++) {
                dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.print(sb);
    }

}