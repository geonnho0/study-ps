import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[][] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static int V;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        arr = new boolean[N + 1][N + 1];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            arr[v][w] = true;
            arr[w][v] = true;
        }

        dfs(V);
        visited = new boolean[N];
        System.out.println();
        bfs(V);
    }

    public static void dfs(int n) {
        visited[n - 1] = true;
        System.out.printf("%d ", n);

        for (int i = 1; i <= visited.length; i++) {
            if (arr[n][i] && !visited[i - 1]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node - 1])
                continue;

            visited[node - 1] = true;
            System.out.printf("%d ", node);

            for (int i = 1; i <= visited.length; i++) {
                if (arr[node][i] && !visited[i - 1]) {
                    queue.offer(i);
                }
            }
        }
    }
}
