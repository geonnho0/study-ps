import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] sum = new long[N + 1];
        long ans = 0;
        sum[0] = scanner.nextInt();
        for (int i = 1; i < N; i++)
            sum[i] = sum[i - 1] + scanner.nextInt();

        long[] c = new long[M + 1];
        for (int i = 0; i < N; i++) {
            int left = (int) (sum[i] % M);
            if (left == 0) ans++;
            c[left]++;
        }

        for (int i = 0; i < M; i++) {
            if (c[i] > 1) {
                ans += c[i] * (c[i] - 1) / 2;
            }
        }

        System.out.println(ans);
    }
}