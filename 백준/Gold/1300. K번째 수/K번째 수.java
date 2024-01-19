import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = scanner.nextInt();

        int start = 1;
        int end = k;
        int mid = 0;
        int res = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int count = 0;
            for (int i = 1; i <= N; i++)
                count += Math.min(mid / i, N);

            if (count >= k) {
                end = mid - 1;
                res = mid;
            }
            else start = mid + 1;
        }
        System.out.println(res);
    }

}