import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        char[] DNA = scanner.next().toCharArray();

        int A = scanner.nextInt();
        int C = scanner.nextInt();
        int G = scanner.nextInt();
        int T = scanner.nextInt();
        int res = 0;
        for (int index = 0; index < M; index++) {
            if (DNA[index] == 'A') A--;
            else if (DNA[index] == 'C') C--;
            else if (DNA[index] == 'G') G--;
            else T--;
        }
        if (A <= 0 && C <= 0 && G <= 0 && T <= 0) res++;

        for (int i = 1; i <= N - M; i++) {
            if (DNA[i - 1] == 'A') A++;
            else if (DNA[i - 1] == 'C') C++;
            else if (DNA[i - 1] == 'G') G++;
            else T++;

            int last = i + M - 1;
            if (DNA[last] == 'A') A--;
            else if (DNA[last] == 'C') C--;
            else if (DNA[last] == 'G') G--;
            else T--;

            if (A <= 0 && C <= 0 && G <= 0 && T <= 0) res++;
        }

        System.out.println(res);
    }
}