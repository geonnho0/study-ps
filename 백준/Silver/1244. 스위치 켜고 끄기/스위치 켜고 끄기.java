import java.util.Scanner;

public class Main {
    static int[] switches;
    static int N;

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        switches = new int[N];
        for (int i = 0; i < N; i++) switches[i] = scanner.nextInt();
        int stu = scanner.nextInt();
        while (stu-- > 0) {
            int gender = scanner.nextInt();
            int num = scanner.nextInt() - 1;

            if (gender == 1) male(num);
            else female(num);
        }

        for (int i = 0; i < N; i++) {
            if (i > 0 && i % 20 == 0) System.out.println();
            System.out.print(switches[i] + " ");
        }
    }

    private static void male(int num) {
        for (int i = num; i < N; i += (num + 1))
            toggle(i);
    }

    private static void female(int num) {
        int left = num - 1, right = num + 1;
        while (left >= 0 && right < N) {
            int l = switches[left], r = switches[right];
            if (l != r) break;
            toggle(left);
            toggle(right);
            left--;
            right++;
        }
        toggle(num);
    }

    private static void toggle(int index) {
        switches[index] = switches[index] == 1 ? 0 : 1;
    }

}