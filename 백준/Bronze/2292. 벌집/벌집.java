import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 1;
        int count = 1;
        while (sum < N) {
            sum += 6 * (count++);
        }
        System.out.println(count);
    }
}
