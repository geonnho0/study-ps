import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static List<Integer> ans;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] v = scanner.next().split("");
            for (int j = 0; j < v.length; j++)
                arr[i][j] = Integer.parseInt(v[j]);
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    dfs(i, j);
                    ans.add(cnt);
                }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int a: ans)
            System.out.println(a);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                continue;

            if (arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                cnt++;
                dfs(nextX, nextY);
            }
        }
    }

}
