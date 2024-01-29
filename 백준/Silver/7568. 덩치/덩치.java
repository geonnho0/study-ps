import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] person = new int[N][2];
        for (int i = 0; i < N; i++) {
            person[i][0] = scanner.nextInt();
            person[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) rank++;
            }
            System.out.print(rank + " ");
        }
    }
}