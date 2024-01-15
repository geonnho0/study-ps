import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];
        int[] sums = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            if (i == 0) sums[i] = arr[i];
            else sums[i] = sums[i - 1] + arr[i];
        }
        for (int t = 0; t < M; t++) {
            int i = scanner.nextInt() - 1;
            int j = scanner.nextInt() - 1;
            System.out.println(sums[j] - sums[i] + arr[i]);
        }
    }
}