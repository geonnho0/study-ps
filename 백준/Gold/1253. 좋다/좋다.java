import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] arr = new long[N];
        int ans = 0;

        for (int i = 0; i < N; i++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);

        for (int index = 0; index < N; index++) {
            int i = 0;
            int j = N - 1;

            while (i < j) {
                long sum = arr[i] + arr[j];
                if (sum == arr[index]) {
                    if (i != index && j != index) {
                        ans++;
                        break;
                    } else if (i == index) i++;
                    else j--;
                } else if (sum < arr[index]) i++;
                else j--;
            }
        }

        System.out.println(ans);
    }
}