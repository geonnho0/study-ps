import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];
        int ans = 0;

        for (int i = 0; i < N; i++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);

        int i = 0;
        int j = N - 1;
        while (i != j) {
            int sum = arr[i] + arr[j];
            if (sum < M) i++;
            else if (sum > M) j--;
            else {
                ans++;
                j--;
            }
        }

        System.out.println(ans);
    }
}