import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] gold = new int[N + 1];
        int[] silver = new int[N + 1];
        int[] bronze = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int country = scanner.nextInt();
            gold[country] = scanner.nextInt();
            silver[country] = scanner.nextInt();
            bronze[country] = scanner.nextInt();
        }
        int res = 1;
        for (int i = 1; i <= N; i++) {
            if (gold[i] > gold[K]) res++;
            else if (gold[i] == gold[K]) {
                if (silver[i] > silver[K]) res++;
                else if (silver[i] == silver[K]) {
                    if (bronze[i] > bronze[K]) res++;
                }
            }
        }
        System.out.println(res);
    }
}