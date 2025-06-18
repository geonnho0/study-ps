import java.io.*;

public class Main {

    private static int solution(int n, int[][] stickers) {
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = stickers[0][0];
        dp[0][2] = stickers[1][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + stickers[0][i];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + stickers[1][i];
        }

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            for (int i = 0; i < 2; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++)
                    stickers[i][j] = Integer.parseInt(line[j]);
            }
            System.out.println(solution(n, stickers));
        }
    }
}