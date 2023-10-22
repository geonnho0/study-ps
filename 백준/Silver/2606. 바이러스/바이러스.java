import java.util.Scanner;

public class Main {

    static boolean[][] arr;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new boolean[n + 1][n + 1];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            arr[v][w] = true;
            arr[w][v] = true;
        }

        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int n) {
        visited[n - 1] = true;

        for (int i = 1; i <= visited.length; i++) {
            if (arr[n][i] && !visited[i - 1]) {
                ans++;
                dfs(i);
            }
        }
    }
}