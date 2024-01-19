import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = scanner.nextInt();
        int count = 0;
        int index = N - 1;
        while (K != 0) {
            if (K - A[index] < 0) {
                index--;
                continue;
            }
            K -= A[index];
            count++;
        }
        System.out.println(count);
    }

}