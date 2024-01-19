import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = scanner.nextInt();
        Arrays.sort(A);

        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int target = scanner.nextInt();
            boolean find = false;

            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int midV = A[mid];
                if (midV > target) end = mid - 1;
                else if (midV < target) start = mid + 1;
                else {
                    find = true;
                    break;
                }
            }

            if (find) System.out.println(1);
            else System.out.println(0);
        }
    }

}