import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i + 1] = Integer.parseInt(line[i]);
        }
        long[][] dp = new long[n + 1][21];
        dp[1][num[1]] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                if (range(j + num[i])) {
                    dp[i][j + num[i]] += dp[i - 1][j];
                }
                if (range(j - num[i])) {
                    dp[i][j - num[i]] += dp[i - 1][j];
                }
            }
        }
        System.out.print(dp[n - 1][num[n]]);
    }

    static boolean range(int num) {
        return 0 <= num && num <= 20;
    }

}