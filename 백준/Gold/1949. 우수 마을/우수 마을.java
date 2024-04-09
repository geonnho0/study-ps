import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[] people;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        graph = new List[N + 1];
        people = new int[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            graph[i + 1] = new ArrayList<>();
            people[i + 1] = Integer.parseInt(line[i]);
        }
        for (int i = 1; i < N; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.print(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = people[node];

        for (int next: graph[node]) {
            if (visited[next])
                continue;
            dfs(next);
            dp[node][0] += Math.max(dp[next][0], dp[next][1]);
            dp[node][1] += dp[next][0];
        }
    }

}