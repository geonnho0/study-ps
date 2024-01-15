import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        String[] numbers = scanner.next().split("");
        int res = 0;
        for (String number: numbers) {
            int num = Integer.parseInt(number);
            res += num;
        }
        System.out.println(res);
    }
}