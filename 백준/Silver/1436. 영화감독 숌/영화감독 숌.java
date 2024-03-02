import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int num = 666;

        for (int i = 1; i <= N; i++) {
            while (true) {
                if (String.valueOf(num).contains("666")) {
                    dp[i] = num;
                    num++;
                    break;
                }
                num++;
            }
        }
        System.out.print(dp[N]);
    }

}