import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] x = new int[M];
        for (int i = 0; i < M; i++) x[i] = scanner.nextInt();

        int before = x[0];
        int ans = 1;
        for (int i = 1; i < M; i++) {
            int after = x[i];
            ans = Math.max((int) Math.ceil((double) (after - before) / 2), ans);
            before = after;
        }

        int first = x[0] - 0;
        int last = N - x[M - 1];
        ans = Math.max(ans, first);
        ans = Math.max(ans, last);

        System.out.println(ans);
    }

}
