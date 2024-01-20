import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] check;
    static boolean even;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bufferedReader.readLine());
        while (K-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int V = Integer.parseInt(strings[0]);
            int E = Integer.parseInt(strings[1]);
            arr = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            even = true;
            for (int i = 1; i < V + 1; i++) arr[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                strings = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(strings[0]);
                int v = Integer.parseInt(strings[1]);
                arr[u].add(v);
                arr[v].add(u);
            }

            for (int i = 1; i <= V; i++) {
                if (!even) break;
                dfs(i);
            }
            if (even) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next: arr[node]) {
            if (!visited[next]) {
                check[next] = (check[node] + 1) % 2;
                dfs(next);
            }
            else if (check[node] == check[next]) even = false;
        }
    }

}