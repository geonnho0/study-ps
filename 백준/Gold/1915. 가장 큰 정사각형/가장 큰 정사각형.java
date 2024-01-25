import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] strings = scanner.nextLine().split("");
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(strings[j]);
        }

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                int left = j - 1;
                int up = i - 1;
                if (left < 0 || up < 0) {
                    dp[i][j] = arr[i][j] == 1 ? 1 : 0;
                    continue;
                }
                if (arr[up][left] == 1 && arr[up][j] == 1 && arr[i][left] == 1) {
                    int min = Math.min(dp[up][left], dp[up][j]);
                    dp[i][j] = Math.min(min, dp[i][left]) + 1;
                }
                else dp[i][j] = 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                max = Math.max(dp[i][j], max);
        System.out.println(max * max);
    }

}