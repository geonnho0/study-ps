import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        long row = (long) Math.ceil((double) W / (1 + M));
        long column = (long) Math.ceil((double) H / (1 + N));
        System.out.println(row * column);
    }
}
