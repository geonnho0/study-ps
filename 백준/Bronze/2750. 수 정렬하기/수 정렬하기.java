import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++)
            num[i] = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            boolean happen = false;
            for (int j = 1; j < N - i; j++) {
                if (num[j - 1] > num[j]) {
                    int temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;
                    happen = true;
                }
            }
            if (!happen) break;
        }

        for (int i = 0; i < N; i++)
            System.out.println(num[i]);
    }
}