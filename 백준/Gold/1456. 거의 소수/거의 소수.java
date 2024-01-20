import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        int[] numbers = new int[10000001];
        for (int i = 2; i < numbers.length; i++)
            numbers[i] = i;

        for (int i = 2; i <= Math.sqrt(numbers.length); i++) {
            int curr = numbers[i];
            if (curr == 0) continue;
            for (int j = i + i; j < numbers.length; j += i) numbers[j] = 0;
        }

        long res = 0;
        for (int i = 2; i < numbers.length; i++) {
            long num = numbers[i];
            if (num != 0) {
                long temp = num;
                while ((double) num <= (double) B / (double) temp) {
                    if ((double) num >= (double) A / (double) temp) res++;
                    temp *= num;
                }
            }
        }
        System.out.println(res);
    }

}