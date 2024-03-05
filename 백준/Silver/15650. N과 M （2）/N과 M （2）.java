import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        visited = new int[N + 1];
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    continue;
                }
                ans.add(visited[i] - 1, i);
            }
            for (int a : ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] > 0) {
                continue;
            }
            visited[i] = depth + 1;
            if (isValid()) {
                dfs(depth + 1);
            }
            visited[i] = 0;
        }
    }

    static boolean isValid() {
        int curr = visited[1];
        for (int i = 2; i <= N; i++) {
            if (visited[i] == 0) {
                continue;
            }
            if (curr > visited[i]) {
                return false;
            }
            curr = visited[i];
        }
        return true;
    }
}