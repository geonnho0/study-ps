import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
            if (i < N - 1 && arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                dp[i][j] = arr[i] == arr[j] && dp[i + 1][j - 1];
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            sb.append(dp[s - 1][e - 1] ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }

}