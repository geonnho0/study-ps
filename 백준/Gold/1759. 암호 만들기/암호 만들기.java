import java.util.*;

public class Main {

    static boolean[] visited;
    static int L, C;
    static char[] chars;
    static char[] password;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine();
        chars = new char[C];
        password = new char[L];
        visited = new boolean[C];
        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < C; i++) {
            chars[i] = line[i].charAt(0);
        }
        dfs(0);
        Collections.sort(ans);
        for (String a : ans) {
            sb.append(a).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int length) {
        if (length == L) {
            if (isValid()) {
                String str = "";
                for (char c: password) {
                    str += c;
                }
                ans.add(str);
            }
            return;
        }
        for (int i = 0; i < C; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            password[length] = chars[i];
            if (isSorted(length + 1)) {
                dfs(length + 1);
            }
            visited[i] = false;
        }
    }

    private static boolean isSorted(int length) {
        char curr = password[0];
        for (int i = 1; i < length; i++) {
            if (curr > password[i]) {
                return false;
            }
            curr = password[i];
        }
        return true;
    }

    private static boolean isValid() {
        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (contains(arr[i])) {
                count++;
            }
        }
        if (count < 1 || L - count < 2) {
            return false;
        }
        return isSorted(L);
    }

    private static boolean contains(char c) {
        for (char p : password) {
            if (p == c) {
                return true;
            }
        }
        return false;
    }

}