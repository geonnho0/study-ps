import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A, B;
        A = scanner.nextLine();
        B = scanner.nextLine();

        int aLength = A.length();
        int bLength = B.length();
        int[][] dp = new int[aLength + 1][bLength + 1];

        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);
                if (a == b) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[aLength][bLength]);
    }

}