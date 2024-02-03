import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] S = scanner.nextLine().split("");
        Arrays.sort(S);
        int length = S.length;
        int zero = 0;
        for (String s: S) {
            if (s.equals("0")) zero++;
            else break;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zero / 2; i++)
            sb.append("0");
        for (int i = zero / 2; i < length / 2; i++)
            sb.append("1");
        System.out.println(sb);
    }

}