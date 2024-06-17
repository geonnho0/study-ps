import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, C;
    static String[] alphabets;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        L = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        alphabets = new String[C];
        line = br.readLine().split(" ");
        for (int i = 0; i < C; i++)
            alphabets[i] = line[i];

        Arrays.sort(alphabets);
        visited = new boolean[C];
        dfs(0, new ArrayList<>());
    }

    static void dfs(int index, List<String> password) {
        if (password.size() == L && check(password)) {
            StringBuilder sb = new StringBuilder();
            for (String p : password)
                sb.append(p);
            System.out.println(sb);
            return;
        }
        for (int i = index; i < C; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            List<String> newPass = new ArrayList<>(password);
            newPass.add(alphabets[i]);
            dfs(i + 1, newPass);
            visited[i] = false;
        }
    }

    static boolean check(List<String> password) {
        if (password.size() < 3)
            return false;
        int count = 0;
        if (password.contains("a")) count++;
        if (password.contains("e")) count++;
        if (password.contains("i")) count++;
        if (password.contains("o")) count++;
        if (password.contains("u")) count++;
        if (count == 0) return false;
        if (password.size() - count >= 2) return true;
        return false;
    }

}