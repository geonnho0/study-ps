import java.io.*;

public class Main {

    static int answer = Integer.MAX_VALUE;

    static int solution(int N, int[][] W) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++)
            backtrack(W, visited, 0, i, i, 0);

        return answer;
    }

    static void backtrack(int[][] W, boolean[] visited, int sum, int start, int curr, int count) {
        if (count == W.length && start == curr) {
            answer = Math.min(answer, sum);
            return;
        }
        if (sum > answer) {
            return;
        }

        for (int i = 0; i < W.length; i++) {
            if (visited[i] || W[curr][i] == 0)
                continue;
            visited[i] = true;
            backtrack(W, visited, sum + W[curr][i], start, i, count + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] W = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(solution(N, W));
    }
}