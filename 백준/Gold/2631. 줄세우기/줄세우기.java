import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] child = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            child[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (child[j] < child[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
                if (max < dp[i]) max = dp[i];
            }
        }

        System.out.println(N - max);
    }

}