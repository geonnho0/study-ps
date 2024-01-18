import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StringBuffer stringBuffer = new StringBuffer();
    static int[][] edges;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) {
        N = scanner.nextInt();
        M = scanner.nextInt();
        int V = scanner.nextInt();
        edges = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            edges[a][b] = 1;
            edges[b][a] = 1;
        }

        dfs(V);
        System.out.println(stringBuffer);
        stringBuffer = new StringBuffer();
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(stringBuffer);
    }

    static void dfs(int num) {
        visited[num] = true;
        stringBuffer.append(num).append(" ");

        for (int i = 1; i <= N; i++) {
            if (edges[num][i] == 0 || visited[i]) continue;
            dfs(i);
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr]) continue;
            visited[curr] = true;
            stringBuffer.append(curr).append(" ");

            for (int i = 1; i <= N; i++) {
                if (edges[curr][i] == 0 || visited[i]) continue;
                queue.add(i);
            }
        }
    }

}