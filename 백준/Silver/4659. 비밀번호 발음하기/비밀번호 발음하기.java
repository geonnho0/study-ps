import java.util.Scanner;

public class Main {

    private static StringBuilder stringBuilder;

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        stringBuilder = new StringBuilder();
        while (true) {
            String password = scanner.nextLine();
            if (password.equals("end")) break;
            else check(password);
        }
        System.out.println(stringBuilder);
    }

    private static void check(String password) {
        boolean first = false, second = true, third = true;
        int length = password.length();
        char one = 0, two = 0, alphabet = 0;
        for (int i = 0; i < length; i++) {
            if (i >= 2) two = one;
            if (i >= 1) one = alphabet;
            alphabet = password.charAt(i);
            if (!first && firstCheck(alphabet)) first = true;
            if (i >= 2 && secondCheck(one, two, alphabet)) second = false;
            if (i >= 1 && thirdCheck(one, alphabet)) third = false;
        }
        stringBuilder.append("<" + password + "> is ");
        if (first && second && third) stringBuilder.append("acceptable.\n");
        else stringBuilder.append("not acceptable.\n");
    }

    private static boolean firstCheck(char a) {
        return isAEIOU(a);
    }

    private static boolean secondCheck(char a, char b, char c) {
        return isAllAEIOU(a, b, c) || isAllNotAEIOU(a, b, c);
    }

    private static boolean thirdCheck(char a, char b) {
        if ((a == 'e' && b == 'e') || (a == 'o' && b == 'o')) return false;
        return a == b;
    }

    private static boolean isAEIOU(char alphabet) {
        return alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u';
    }

    private static boolean isAllAEIOU(char a, char b, char c) {
        return isAEIOU(a) && isAEIOU(b) && isAEIOU(c);
    }

    private static boolean isAllNotAEIOU(char a, char b, char c) {
        return !isAEIOU(a) && !isAEIOU(b) && !isAEIOU(c);
    }
}