import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().toLowerCase().split("");
        int[] index = new int[26];
        for (String s: str) {
            char c = s.charAt(0);
            int i = c - 'a';
            index[i]++;
        }
        int max = 0;
        for (int i: index)
            if (i > max) max = i;
        int ans = -1;
        for (int i = 0; i < 26; i++) {
            if (index[i] != max) continue;
            if (ans != -1) {
                System.out.println("?");
                return;
            }
            ans = i;
        }
        System.out.println((char) (ans + 'A'));
    }
}
